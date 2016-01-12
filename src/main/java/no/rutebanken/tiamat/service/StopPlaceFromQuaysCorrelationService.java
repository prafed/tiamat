package no.rutebanken.tiamat.service;

import com.vividsolutions.jts.algorithm.CentroidPoint;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import no.rutebanken.tiamat.pelias.CountyAndMunicipalityLookupService;
import no.rutebanken.tiamat.repository.ifopt.QuayRepository;
import no.rutebanken.tiamat.repository.ifopt.StopPlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.org.netex.netex.MultilingualString;
import uk.org.netex.netex.Quay;
import uk.org.netex.netex.SimplePoint;
import uk.org.netex.netex.StopPlace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class StopPlaceFromQuaysCorrelationService {
    private static final Logger logger = LoggerFactory.getLogger(StopPlaceFromQuaysCorrelationService.class);

    /**
     * The max distance for checking if two quays are nearby each other.
     * http://gis.stackexchange.com/questions/28799/what-is-the-unit-of-measurement-for-buffer-calculation
     * https://en.wikipedia.org/wiki/Decimal_degrees
     */
    public static final double DISTANCE = 0.008;

    private final QuayRepository quayRepository;

    private final StopPlaceRepository stopPlaceRepository;

    private final AtomicInteger stopPlaceCounter = new AtomicInteger();

    private final GeometryFactory geometryFactory;

    private final CountyAndMunicipalityLookupService countyAndMunicipalityLookupService;

    @Autowired
    public StopPlaceFromQuaysCorrelationService(QuayRepository quayRepository,
                                                StopPlaceRepository stopPlaceRepository,
                                                GeometryFactory geometryFactory,
                                                CountyAndMunicipalityLookupService countyAndMunicipalityLookupService) {
        this.quayRepository = quayRepository;
        this.stopPlaceRepository = stopPlaceRepository;
        this.geometryFactory = geometryFactory;
        this.countyAndMunicipalityLookupService = countyAndMunicipalityLookupService;
    }

    /**
     * Creates stopPlace objects based on quays by combining quays with the same
     * name and close location
     */
    public void correlate() {

        logger.trace("Loading quays from repository");
        List<Quay> quays = quayRepository.findAll();

        logger.trace("Got {} quays", quays.size());

        Map<String, List<Quay>> distinctQuays = quays.stream()
                .collect(Collectors.groupingBy(quay -> quay.getName().getValue()));

        logger.trace("Got {} distinct quays based on name", distinctQuays.size());

        List<String> quaysAlreadyProcessed = new ArrayList<>();

        distinctQuays.keySet().forEach(quayGroupName -> {

            logger.trace("Processing quay with name {}", quayGroupName);

            StopPlace stopPlace = new StopPlace();
            stopPlace.setName(new MultilingualString(quayGroupName, "no", ""));

            stopPlace.setQuays(new ArrayList<>());

            distinctQuays.get(quayGroupName).forEach(quay -> {

                boolean addQuay = false;

                if (quaysAlreadyProcessed.contains(quay.getId())) {

                    logger.warn("Already created quay with name {} and id {}", quay.getName(), quay.getId());

                } else if (stopPlace.getQuays().isEmpty()) {

                    logger.debug("There are no quays related to stop place {} yet. Will add quay.", stopPlace.getName());
                    addQuay = true;

                } else if (quayIsCloseToExistingQuays(quay, stopPlace.getQuays())){

                    logger.info("Quay {}, {} is close enough to be added",
                            quay.getName(),
                            quay.getCentroid().getLocation().toText());
                    addQuay = true;
                } else {
                    logger.info("Ignoring quay {} {}", quay.getName(), quay.getCentroid().getLocation().toText());
                }

                if(addQuay) {
                    logger.trace("About to add Quay with name {} and id {} to stop place", quay.getName(), quay.getId());

                    stopPlace.getQuays().add(quay);

                    quaysAlreadyProcessed.add(quay.getId());
                }

            });

            if(stopPlace.getQuays().isEmpty()) {
                logger.warn("No quays were added to stop place {} {}. Skipping...", stopPlace.getName(), stopPlace.getId());
            } else {

                stopPlace.setCentroid(new SimplePoint());
                stopPlace.getCentroid().setLocation(calculateCentroidForStopPlace(stopPlace.getQuays()));

                try {
                    countyAndMunicipalityLookupService.populateCountyAndMunicipality(stopPlace);
                    stopPlaceRepository.save(stopPlace);
                    logger.debug("Created stop place number {} with name {} and {} quays (id {})",
                            stopPlaceCounter.incrementAndGet(), stopPlace.getName(), stopPlace.getQuays().size(), stopPlace.getId());
                } catch (Exception e) {
                    logger.warn("Caught exception when saving stop place with name {}", quayGroupName, e);
                }
            }
        });

        logger.debug("Amount of created stop places: {}", stopPlaceCounter.get());
    }

    public boolean quayIsCloseToExistingQuays(Quay otherQuay, List<Quay> existingQuays) {
        return existingQuays.stream().allMatch(q ->areClose(otherQuay,q));
    }

    /**
     * Check if two quays are close, using the DISTANCE constant.
     *
     * http://www.vividsolutions.com/jts/javadoc/com/vividsolutions/jts/geom/Geometry.html#buffer(double)
     */
    public boolean areClose(Quay quay, Quay otherQuay) {

        if(quay == null || otherQuay == null) {
            return false;
        }
        Geometry buffer = quay.getCentroid().getLocation().buffer(DISTANCE);
        boolean intersects = buffer.intersects(otherQuay.getCentroid().getLocation());

        if(intersects) {
            logger.debug("Quay {} {} is close to quay {} {}",
                    quay.getName(),
                    quay.getCentroid().getLocation().toText(),
                    otherQuay.getName(),
                    otherQuay.getCentroid().getLocation().toText());
            return true;
        }

        logger.debug("Quay {} {} is NOT close to quay {} {}",
                quay.getName(),
                quay.getCentroid().getLocation().toText(),
                otherQuay.getName(),
                otherQuay.getCentroid().getLocation().toText());
        return false;
    }

    public Point calculateCentroidForStopPlace(List<Quay> quays) {
        CentroidPoint centroidPoint = new CentroidPoint();
        quays.forEach(quay -> centroidPoint.add(quay.getCentroid().getLocation()));

        logger.debug("Created centroid for stop place based on {} quays. x: {}, y: {}", quays.size(),
                centroidPoint.getCentroid().x, centroidPoint.getCentroid().y);

        return geometryFactory.createPoint(centroidPoint.getCentroid());
    }

}
