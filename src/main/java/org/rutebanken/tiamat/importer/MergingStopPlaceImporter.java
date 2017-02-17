package org.rutebanken.tiamat.importer;

import org.rutebanken.tiamat.importer.finder.NearbyStopPlaceFinder;
import org.rutebanken.tiamat.importer.finder.NearbyStopsWithSameTypeFinder;
import org.rutebanken.tiamat.importer.finder.StopPlaceFromOriginalIdFinder;
import org.rutebanken.tiamat.model.Quay;
import org.rutebanken.tiamat.model.SiteFrame;
import org.rutebanken.tiamat.model.StopPlace;
import org.rutebanken.tiamat.netex.mapping.NetexMapper;
import org.rutebanken.tiamat.netex.mapping.mapper.NetexIdMapper;
import org.rutebanken.tiamat.pelias.CountyAndMunicipalityLookupService;
import org.rutebanken.tiamat.repository.QuayRepository;
import org.rutebanken.tiamat.repository.StopPlaceRepository;
import org.rutebanken.tiamat.service.CentroidComputer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Qualifier("mergingStopPlaceImporter")
@Transactional
public class MergingStopPlaceImporter {

    private static final Logger logger = LoggerFactory.getLogger(MergingStopPlaceImporter.class);

    private final TopographicPlaceCreator topographicPlaceCreator;

    private final CountyAndMunicipalityLookupService countyAndMunicipalityLookupService;

    private final QuayRepository quayRepository;

    private final StopPlaceRepository stopPlaceRepository;

    private final StopPlaceFromOriginalIdFinder stopPlaceFromOriginalIdFinder;

    private final NearbyStopsWithSameTypeFinder nearbyStopsWithSameTypeFinder;

    private final NearbyStopPlaceFinder nearbyStopPlaceFinder;

    private final CentroidComputer centroidComputer;

    private final KeyValueListAppender keyValueListAppender;

    private final QuayMerger quayMerger;

    private final NetexMapper netexMapper;

    private final VersionIncrementor versionIncrementor;


    @Autowired
    public MergingStopPlaceImporter(TopographicPlaceCreator topographicPlaceCreator,
                                    CountyAndMunicipalityLookupService countyAndMunicipalityLookupService,
                                    QuayRepository quayRepository, StopPlaceRepository stopPlaceRepository,
                                    StopPlaceFromOriginalIdFinder stopPlaceFromOriginalIdFinder,
                                    NearbyStopsWithSameTypeFinder nearbyStopsWithSameTypeFinder, NearbyStopPlaceFinder nearbyStopPlaceFinder,
                                    CentroidComputer centroidComputer,
                                    KeyValueListAppender keyValueListAppender, QuayMerger quayMerger, NetexMapper netexMapper, VersionIncrementor versionIncrementor) {
        this.topographicPlaceCreator = topographicPlaceCreator;
        this.countyAndMunicipalityLookupService = countyAndMunicipalityLookupService;
        this.quayRepository = quayRepository;
        this.stopPlaceRepository = stopPlaceRepository;
        this.stopPlaceFromOriginalIdFinder = stopPlaceFromOriginalIdFinder;
        this.nearbyStopsWithSameTypeFinder = nearbyStopsWithSameTypeFinder;
        this.nearbyStopPlaceFinder = nearbyStopPlaceFinder;
        this.centroidComputer = centroidComputer;
        this.keyValueListAppender = keyValueListAppender;
        this.quayMerger = quayMerger;
        this.netexMapper = netexMapper;
        this.versionIncrementor = versionIncrementor;
    }

    /**
     * When importing site frames in multiple threads, and those site frames might contain different stop places that will be merged,
     * we run into the risk of having multiple threads trying to save the same stop place.
     *
     * That's why we use a striped semaphore to not work on the same stop place concurrently. (SiteFrameImporter)
     * it is important to flush the session between each stop place, *before* the semaphore has been released.
     *
     * Attempts to use saveAndFlush or hibernate flush mode always have not been successful.
     */
    public org.rutebanken.netex.model.StopPlace importStopPlace(StopPlace newStopPlace) throws InterruptedException, ExecutionException {

        logger.debug("Transaction active: {}. Isolation level: {}", TransactionSynchronizationManager.isActualTransactionActive(), TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());

        if(!TransactionSynchronizationManager.isActualTransactionActive()) {
            throw new RuntimeException("Transaction with required "
                    + "TransactionSynchronizationManager.isActualTransactionActive(): " + TransactionSynchronizationManager.isActualTransactionActive());
        }

        return netexMapper.mapToNetexModel(importStopPlaceWithoutNetexMapping(newStopPlace));
    }

    public StopPlace importStopPlaceWithoutNetexMapping(StopPlace newStopPlace) throws InterruptedException, ExecutionException {
        final StopPlace foundStopPlace = findNearbyOrExistingStopPlace(newStopPlace);

        final StopPlace stopPlace;
        if (foundStopPlace != null) {
            stopPlace = handleAlreadyExistingStopPlace(foundStopPlace, newStopPlace);
        } else {
            stopPlace = handleCompletelyNewStopPlace(newStopPlace);

        }
        return stopPlace;
    }


    public StopPlace handleCompletelyNewStopPlace(StopPlace newStopPlace) throws ExecutionException {

        if(newStopPlace.getId() != null) {
            newStopPlace.setId(null);
            if(newStopPlace.getQuays() != null) {
                newStopPlace.getQuays().forEach(q -> q.setId(null));
            }
        }

        /*if (newStopPlace.getTopographicPlaceRef() == null) {
            if (hasTopographicPlaces(siteFrame)) {
                topographicPlaceCreator.setTopographicReference(newStopPlace,
                        siteFrame.getTopographicPlaces().getTopographicPlace(),
                        topographicPlacesCreatedCounter);
            } else {
                lookupCountyAndMunicipality(newStopPlace, topographicPlacesCreatedCounter);
            }
        }*/
        if(newStopPlace.getQuays() != null) {
            Set<Quay> quays = quayMerger.addNewQuaysOrAppendImportIds(newStopPlace.getQuays(), null, new AtomicInteger(), new AtomicInteger());
            newStopPlace.setQuays(quays);
            logger.trace("Importing quays for new stop place {}", newStopPlace);
        }

        centroidComputer.computeCentroidForStopPlace(newStopPlace);
        // Ignore incoming version. Always set version to 1 for new stop places.
        logger.debug("New stop place: {}. Setting version to \"1\"", newStopPlace.getName());
        newStopPlace.setVersion("1");
        newStopPlace.setCreated(ZonedDateTime.now());
        newStopPlace.setChanged(ZonedDateTime.now());
        return saveAndUpdateCache(newStopPlace);
    }

    public StopPlace handleAlreadyExistingStopPlace(StopPlace foundStopPlace, StopPlace newStopPlace) {
        logger.debug("Found existing stop place {} from incoming {}", foundStopPlace, newStopPlace);

        boolean quayChanged = quayMerger.addNewQuaysOrAppendImportIds(newStopPlace, foundStopPlace);
        boolean keyValuesChanged = keyValueListAppender.appendToOriginalId(NetexIdMapper.ORIGINAL_ID_KEY, newStopPlace, foundStopPlace);
        boolean centroidChanged = centroidComputer.computeCentroidForStopPlace(foundStopPlace);

        boolean typeChanged = false;
        if(foundStopPlace.getStopPlaceType() == null && newStopPlace.getStopPlaceType() != null) {
            foundStopPlace.setStopPlaceType(newStopPlace.getStopPlaceType());
            logger.info("Updated stop place type to {} for stop place {}", foundStopPlace.getStopPlaceType(), foundStopPlace);
            typeChanged = true;

        }

        if(quayChanged || keyValuesChanged || centroidChanged || typeChanged) {
            foundStopPlace.setChanged(ZonedDateTime.now());
        }
        logger.info("Updated existing stop place {}. ", foundStopPlace);
        versionIncrementor.incrementVersion(foundStopPlace);

        return saveAndUpdateCache(foundStopPlace);
    }

    private StopPlace saveAndUpdateCache(StopPlace stopPlace) {
        // Keep the attached stop place reference in case it is merged.
        stopPlace = stopPlaceRepository.save(stopPlace);

        if (stopPlace.getQuays() != null) {
            for (Quay quay : stopPlace.getQuays()) {
                quayRepository.save(quay);
            }
        }

        stopPlaceFromOriginalIdFinder.update(stopPlace);
        nearbyStopPlaceFinder.update(stopPlace);
        logger.info("Saved stop place {}", stopPlace);
        return stopPlace;
    }

//    private boolean hasTopographicPlaces(SiteFrame siteFrame) {
//        return siteFrame.getTopographicPlaces() != null
//                && siteFrame.getTopographicPlaces().getTopographicPlace() != null
//                && !siteFrame.getTopographicPlaces().getTopographicPlace().isEmpty();
//    }
//
//    private void lookupCountyAndMunicipality(StopPlace stopPlace, AtomicInteger topographicPlacesCreatedCounter) {
//        try {
//            countyAndMunicipalityLookupService.populateCountyAndMunicipality(stopPlace, topographicPlacesCreatedCounter);
//        } catch (IOException | InterruptedException e) {
//            logger.warn("Could not lookup county and municipality for stop place with id {}", stopPlace.getId());
//        }
//    }

    private StopPlace findNearbyOrExistingStopPlace(StopPlace newStopPlace) {
        final StopPlace existingStopPlace = stopPlaceFromOriginalIdFinder.find(newStopPlace);
        if (existingStopPlace != null) {
            return existingStopPlace;
        }

        if (newStopPlace.getName() != null) {
            final StopPlace nearbyStopPlace = nearbyStopPlaceFinder.find(newStopPlace);
            if (nearbyStopPlace != null) {
                logger.debug("Found nearby stop place with name: {}, id: {}", nearbyStopPlace.getName(), nearbyStopPlace.getId());
                return nearbyStopPlace;
            }
        }

        // Find existing nearby stop place based on type
        final List<StopPlace> nearbyStopsWithSameType = nearbyStopsWithSameTypeFinder.find(newStopPlace);
        if(!nearbyStopsWithSameType.isEmpty()) {
            StopPlace nearbyStopWithSameType = nearbyStopsWithSameType.get(0);
            logger.debug("Found nearby stop place with same type: {}", nearbyStopWithSameType);
            return nearbyStopWithSameType;
        }
        return null;
    }

}