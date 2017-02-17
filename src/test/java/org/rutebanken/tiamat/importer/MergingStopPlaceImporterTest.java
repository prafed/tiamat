package org.rutebanken.tiamat.importer;

import com.google.common.collect.Sets;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import org.junit.Test;
import org.rutebanken.tiamat.config.GeometryFactoryConfig;
import org.rutebanken.tiamat.geo.EnvelopeCreator;
import org.rutebanken.tiamat.importer.finder.NearbyStopPlaceFinder;
import org.rutebanken.tiamat.importer.finder.NearbyStopsWithSameTypeFinder;
import org.rutebanken.tiamat.importer.finder.StopPlaceFromOriginalIdFinder;
import org.rutebanken.tiamat.model.*;
import org.rutebanken.tiamat.netex.mapping.NetexMapper;
import org.rutebanken.tiamat.netex.mapping.mapper.NetexIdMapper;
import org.rutebanken.tiamat.pelias.CountyAndMunicipalityLookupService;
import org.rutebanken.tiamat.repository.QuayRepository;
import org.rutebanken.tiamat.repository.StopPlaceRepository;
import org.rutebanken.tiamat.service.CentroidComputer;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.HOURS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.rutebanken.tiamat.netex.mapping.mapper.NetexIdMapper.ORIGINAL_ID_KEY;

/**
 * Test stop place importer with mocked dependencies.
 * See also {@link MergingStopPlaceImporterWithGeoDBTest}
 */
public class MergingStopPlaceImporterTest {

    private GeometryFactory geometryFactory = new GeometryFactoryConfig().geometryFactory();

    private CentroidComputer centroidComputer = new CentroidComputer(geometryFactory);

    private TopographicPlaceCreator topographicPlaceCreator = mock(TopographicPlaceCreator.class);

    private QuayRepository quayRepository = mock(QuayRepository.class);

    private StopPlaceRepository stopPlaceRepository = mock(StopPlaceRepository.class);

    private StopPlaceFromOriginalIdFinder stopPlaceFromOriginalIdFinder = new StopPlaceFromOriginalIdFinder(stopPlaceRepository, 100, 10, HOURS);

    private NearbyStopPlaceFinder nearbyStopPlaceFinder = new NearbyStopPlaceFinder(stopPlaceRepository, 20000, 30, TimeUnit.MINUTES);

    private CountyAndMunicipalityLookupService countyAndMunicipalityLookupService = mock(CountyAndMunicipalityLookupService.class);

    private KeyValueListAppender keyValueListAppender = new KeyValueListAppender();

    private VersionIncrementor versionIncrementor = new VersionIncrementor();

    private QuayMerger quayMerger = new QuayMerger(versionIncrementor);

    private NetexMapper netexMapper = new NetexMapper();

    private NearbyStopsWithSameTypeFinder nearbyStopsWithSameTypeFinder = new NearbyStopsWithSameTypeFinder(stopPlaceRepository, new EnvelopeCreator(geometryFactory));
    private MergingStopPlaceImporter stopPlaceImporter = new MergingStopPlaceImporter(topographicPlaceCreator,
            countyAndMunicipalityLookupService, quayRepository, stopPlaceRepository, stopPlaceFromOriginalIdFinder,
            nearbyStopsWithSameTypeFinder, nearbyStopPlaceFinder, centroidComputer, keyValueListAppender, quayMerger, netexMapper, versionIncrementor);

    private SiteFrame siteFrame = new SiteFrame();

    /**
     * Test that two nearby stops close to each other is treated as the same.
     * Note that the DB query is mocked. To test this with h2 use {@link MergingStopPlaceImporterWithGeoDBNoCacheTest}
     */
    @Test
    public void findNearbyStopWithSameType() throws ExecutionException, InterruptedException {

        Long firstStopId = 1L;
        StopPlace firstStopPlace = new StopPlace();
        firstStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(10.7096245, 59.9086885)));
        firstStopPlace.setName(new EmbeddableMultilingualString("Filipstad", "no"));
        firstStopPlace.setId(firstStopId);
        firstStopPlace.setVersion("1");
        firstStopPlace.setStopPlaceType(StopTypeEnumeration.ONSTREET_BUS);

        Quay terminal1 = new Quay();
        terminal1.setName(new EmbeddableMultilingualString("Filipstad"));
        terminal1.setId(2L);
        terminal1.setCentroid(geometryFactory.createPoint(new Coordinate(10.7096245, 59.9086885)));

        firstStopPlace.getQuays().add(terminal1);

        mockStopPlaceSave(firstStopId, firstStopPlace);

        StopPlace secondStopPlace = new StopPlace();
        secondStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(10.709707, 59.908737)));
        secondStopPlace.setName(new EmbeddableMultilingualString("Filipstad ferjeterminal", "no"));
        secondStopPlace.setStopPlaceType(StopTypeEnumeration.ONSTREET_BUS);

        Quay terminal2 = new Quay();
        terminal2.setName(new EmbeddableMultilingualString("Filipstad ferjeterminal"));
        terminal2.setId(3L);
        terminal2.setCentroid(geometryFactory.createPoint(new Coordinate(10.709707, 59.908737)));
        secondStopPlace.getQuays().add(terminal2);


        when(stopPlaceRepository.findNearbyStopPlace(any(Envelope.class), any(StopTypeEnumeration.class))).thenReturn(Arrays.asList(firstStopId));
        when(stopPlaceRepository.findAll(anyCollection())).thenReturn(Arrays.asList(firstStopPlace));

        // Import only the second stop place as the first one is already "saved" (mocked)
        StopPlace importResult = stopPlaceImporter.importStopPlaceWithoutNetexMapping(secondStopPlace);

        assertThat(importResult.getId()).isEqualTo(firstStopId);
        assertThat(importResult.getVersion()).isEqualTo("2");
    }

    /**
     * The second time the stop place is imported, the type must be updated if it was empty.
     */
    @Test
    public void updateStopPlaceType() throws ExecutionException, InterruptedException {

        Point point = geometryFactory.createPoint(new Coordinate(10.7096245, 59.9086885));

        Long firstStopId = 1L;
        StopPlace firstStopPlace = new StopPlace();
        firstStopPlace.setCentroid(point);
        firstStopPlace.setName(new EmbeddableMultilingualString("Filipstad", "no"));
        firstStopPlace.setId(firstStopId);
        firstStopPlace.getOrCreateValues(NetexIdMapper.ORIGINAL_ID_KEY).add("original-id");
        firstStopPlace.setVersion("1");

        StopPlace newStopPlace = new StopPlace();
        newStopPlace.setCentroid(point);
        newStopPlace.setName(new EmbeddableMultilingualString("Filipstad", "no"));
        newStopPlace.setStopPlaceType(StopTypeEnumeration.ONSTREET_BUS);

        when(stopPlaceRepository.findNearbyStopPlace(any(Envelope.class), any(String.class), any(StopTypeEnumeration.class))).thenReturn(firstStopId);
        when(stopPlaceRepository.findOne(firstStopId)).thenReturn(firstStopPlace);
        when(stopPlaceRepository.save(firstStopPlace)).thenReturn(firstStopPlace);

        StopPlace importResult = stopPlaceImporter.importStopPlaceWithoutNetexMapping(newStopPlace);

        assertThat(importResult.getId()).isEqualTo(firstStopId);
        assertThat(importResult.getStopPlaceType()).isEqualTo(StopTypeEnumeration.ONSTREET_BUS);
    }

    @Test
    public void detectAndMergeQuaysFromTwoSimilarStopPlaces() throws ExecutionException, InterruptedException {

        Long firstStopId = 1L;
        StopPlace firstStopPlace = new StopPlace();
        firstStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(59.933307, 10.775973)));
        firstStopPlace.setName(new EmbeddableMultilingualString("Andalsnes", "no"));
        firstStopPlace.setId(firstStopId);
        firstStopPlace.setVersion("1");
        firstStopPlace.setStopPlaceType(StopTypeEnumeration.ONSTREET_BUS);

        Quay terminal1 = new Quay();
        terminal1.setName(new EmbeddableMultilingualString("terminal 1"));
        terminal1.setId(2L);
        terminal1.setCentroid(geometryFactory.createPoint(new Coordinate(60.000, 10.78)));

        firstStopPlace.getQuays().add(terminal1);

        StopPlace secondStopPlace = new StopPlace();
        secondStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(60.000, 10.78)));
        secondStopPlace.setName(new EmbeddableMultilingualString("Andalsnes", "no"));
        secondStopPlace.setStopPlaceType(StopTypeEnumeration.ONSTREET_BUS);

        Quay terminal2 = new Quay();
        terminal2.setName(new EmbeddableMultilingualString("terminal 2"));
        terminal2.setId(3L);
        terminal2.setCentroid(geometryFactory.createPoint(new Coordinate(60.01, 10.78)));
        secondStopPlace.getQuays().add(terminal2);

        mockStopPlaceSave(firstStopId, firstStopPlace);
        when(stopPlaceRepository.findNearbyStopPlace(any(Envelope.class), any(String.class), any(StopTypeEnumeration.class))).thenReturn(firstStopId);
        when(stopPlaceRepository.findOne(firstStopId)).thenReturn(firstStopPlace);

        // Import only the second stop place as the first one is already "saved" (mocked)
        StopPlace importResult = stopPlaceImporter.importStopPlaceWithoutNetexMapping(secondStopPlace);

        assertThat(importResult.getId()).isEqualTo(importResult.getId());
        assertThat(importResult.getQuays()).hasSize(2);
        assertThat(importResult.getVersion()).isEqualTo("2");
    }


    @Test
    public void handleDuplicateStopPlacesBasedOnId() throws ExecutionException, InterruptedException {


        StopPlace firstStopPlace = new StopPlace();
        firstStopPlace.setId(1L);
        firstStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(59.933307, 10.775973)));
        firstStopPlace.setName(new EmbeddableMultilingualString("skjeberg", "no"));

        StopPlace secondStopPlace = new StopPlace();
        secondStopPlace.setId(firstStopPlace.getId());
        secondStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(59.933307, 10.775973)));
        secondStopPlace.setName(new EmbeddableMultilingualString("skjeberg", "no"));


        Long savedId = 2L;

        when(stopPlaceRepository.save(firstStopPlace)).then(invocationOnMock -> {
            StopPlace stopPlace = (StopPlace) invocationOnMock.getArguments()[0];
            stopPlace.setId(savedId);
            return stopPlace;
        });

        StopPlace importedStopPlace1 = stopPlaceImporter.importStopPlaceWithoutNetexMapping(firstStopPlace);


        when(stopPlaceRepository.findByKeyValue(anyString(), anySet()))
                .then(invocationOnMock -> {
                    System.out.println("Returning the first stop place");
                    return importedStopPlace1;
                });

        when(stopPlaceRepository.findOne(anyLong())).then(invocationOnMock -> importedStopPlace1);

        StopPlace importedStopPlace2 = stopPlaceImporter.importStopPlaceWithoutNetexMapping(secondStopPlace);


        assertThat(importedStopPlace2.getId())
                .isEqualTo(importedStopPlace1.getId())
                .isEqualTo(savedId)
                .as("The same stop place should be returned as they have the same chouette id");
    }

    /**
     * When importing a stop place with matching chouette ID, the quay should be added to existing stop place.
     */
    @Test
    public void detectAndMergeQuaysForExistingStopPlace() throws ExecutionException, InterruptedException {
        final Long savedStopPlaceId = 1L;
        final String chouetteId = "OPP:StopArea:321";
        final String chouetteQuayId = "OPP:Quays:3333";

        StopPlace firstStopPlace = new StopPlace();
        firstStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(70.933307, 10.775973)));
        firstStopPlace.getOrCreateValues(NetexIdMapper.ORIGINAL_ID_KEY).add(chouetteId);

        Quay terminal1 = new Quay();
        terminal1.getOrCreateValues(NetexIdMapper.ORIGINAL_ID_KEY).add(chouetteQuayId);
        terminal1.setCentroid(geometryFactory.createPoint(new Coordinate(70.000, 10.78)));
        firstStopPlace.getQuays().add(terminal1);

        StopPlace secondStopPlace = new StopPlace();
        // Intentionally setting centroid way off the first stop place. Because the importer should match the chouette ID
        secondStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(80.000, 20.78)));
        // Set same ID as first stop place
        secondStopPlace.getOrCreateValues(NetexIdMapper.ORIGINAL_ID_KEY).add(chouetteId);

        Quay terminal2 = new Quay();
        terminal2.getOrCreateValues(NetexIdMapper.ORIGINAL_ID_KEY).add(chouetteQuayId);
        terminal2.setCentroid(geometryFactory.createPoint(new Coordinate(70.000, 10.78)));
        secondStopPlace.getQuays().add(terminal2);

        mockStopPlaceSave(savedStopPlaceId, firstStopPlace);
        when(stopPlaceRepository.findByKeyValue(ORIGINAL_ID_KEY, Sets.newHashSet(String.valueOf(chouetteId)))).thenReturn(savedStopPlaceId);
        when(stopPlaceRepository.findOne(savedStopPlaceId)).thenReturn(firstStopPlace);

        // Import only the second stop place as the first one is already "saved" (mocked)
        StopPlace importResult = stopPlaceImporter.importStopPlaceWithoutNetexMapping(secondStopPlace);

        assertThat(importResult.getId()).isEqualTo(importResult.getId());
        assertThat(importResult.getQuays()).hasSize(1);
    }

    /**
     * When importing a stop place which already exists, matching quays should not be duplicated.
     */
    @Test
    public void detectTwoMatchingQuaysInTwoSeparateStopPlaces() throws ExecutionException, InterruptedException {
        final Long savedStopPlaceId = 1L;
        final String chouetteId = "OPP:StopArea:123123";

        StopPlace firstStopPlace = new StopPlace();
        firstStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(70.933307, 10.775973)));
        firstStopPlace.setId(savedStopPlaceId);

        Quay terminal1 = new Quay();
        terminal1.setCentroid(geometryFactory.createPoint(new Coordinate(70.000, 10.78)));
        firstStopPlace.getQuays().add(terminal1);

        StopPlace secondStopPlace = new StopPlace();
        // Intentionally setting centroid way off the first stop place. Because the importer should match the chouette ID
        secondStopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(80.000, 20.78)));

        // Set same ID as first stop place
        secondStopPlace.getOrCreateValues(NetexIdMapper.ORIGINAL_ID_KEY).add(chouetteId);

        Quay terminal2 = new Quay();
        terminal2.setCentroid(geometryFactory.createPoint(new Coordinate(70.000, 10.78)));
        secondStopPlace.getQuays().add(terminal2);

        mockStopPlaceSave(savedStopPlaceId, firstStopPlace);
        when(stopPlaceRepository.findByKeyValue(ORIGINAL_ID_KEY, Sets.newHashSet(String.valueOf(chouetteId)))).thenReturn(savedStopPlaceId);
        when(stopPlaceRepository.findOne(savedStopPlaceId)).thenReturn(firstStopPlace);

        // Import only the second stop place as the first one is already "saved" (mocked)
        StopPlace importResult = stopPlaceImporter.importStopPlaceWithoutNetexMapping(secondStopPlace);

        assertThat(importResult.getId()).isEqualTo(savedStopPlaceId);
        // Expect only one quay when two quays have the same coordinates
        assertThat(importResult.getQuays()).hasSize(1);
        assertThat(importResult.getQuays()).contains(terminal1);
    }

    /**
     * NRP-830 New stop (or existing)must be merged by original ID or coordinate.
     */
    @Test
    public void mergeIncomingQuaysForStopPlace() throws ExecutionException, InterruptedException {
        final String chouetteId = "OPP:StopArea:321";
        final String chouetteQuayId = "OPP:Quays:3333";

        StopPlace stopPlace = new StopPlace();
        stopPlace.setCentroid(geometryFactory.createPoint(new Coordinate(70.933307, 10.775973)));
        stopPlace.getOrCreateValues(NetexIdMapper.ORIGINAL_ID_KEY).add(chouetteId);

        Quay quay1 = new Quay();
        quay1.setCentroid(geometryFactory.createPoint(new Coordinate(70.000, 10.78)));
        quay1.getOrCreateValues(NetexIdMapper.ORIGINAL_ID_KEY).add(chouetteQuayId);
        stopPlace.getQuays().add(quay1);

        when(stopPlaceRepository.save(stopPlace)).thenReturn(stopPlace);
        StopPlace actual = stopPlaceImporter.importStopPlaceWithoutNetexMapping(stopPlace);

        assertThat(actual.getQuays()).hasSize(1);
    }


    private void mockStopPlaceSave(Long persistedStopPlaceId, StopPlace stopPlace) {
        when(stopPlaceRepository.save(stopPlace)).then(invocationOnMock -> {
            StopPlace stopPlaceToSave = (StopPlace) invocationOnMock.getArguments()[0];
            stopPlaceToSave.setId(persistedStopPlaceId);
            return stopPlaceToSave;
        });
    }
}