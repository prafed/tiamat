package org.rutebanken.tiamat.service;

import org.junit.Test;
import org.rutebanken.tiamat.TiamatIntegrationTest;
import org.rutebanken.tiamat.model.EmbeddableMultilingualString;
import org.rutebanken.tiamat.model.StopPlace;
import org.rutebanken.tiamat.model.ValidBetween;
import org.rutebanken.tiamat.repository.StopPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
public class MultiModalStopPlaceEditorTest extends TiamatIntegrationTest {

    @Autowired
    private StopPlaceRepository stopPlaceRepository;

    @Autowired
    private MultiModalStopPlaceEditor multiModalStopPlaceEditor;

    @Test
    public void testCreateMultiModalParentStopPlace() {

        List<StopPlace> children = new ArrayList<>();
        children.add(createStopPlace("StopPlace - 1"));
        children.add(createStopPlace("StopPlace - 2"));
        children.add(createStopPlace("StopPlace - 3"));
        children.add(createStopPlace("StopPlace - 4"));

        List<StopPlace> savedChildren = stopPlaceRepository.save(children);

        List<String> childIds = new ArrayList<>();
        savedChildren.forEach(sp -> {
            childIds.add(sp.getNetexId());
        });

        String parentStopPlaceName = "Super StopPlace";
        StopPlace result = multiModalStopPlaceEditor.createMultiModalParentStopPlace(childIds, new EmbeddableMultilingualString(parentStopPlaceName));
        assertThat(result.getName().getValue()).isEqualTo(parentStopPlaceName);
        assertThat(result.getVersion()).isEqualTo(1L);
        assertThat(result.getValidBetween()).isNotNull();
        assertThat(result.getNetexId()).isNotNull();

        assertThatChildsAreReferencingParentAndHasNoName(childIds, result);
    }


    @Test
    public void testCreateMultiModalParentStopPlaceFromVersionedChild() {

        StopPlace firstStopPlace = createStopPlace("first");
        firstStopPlace.setVersion(1L);
        firstStopPlace = stopPlaceRepository.save(firstStopPlace);

        StopPlace firstStopPlaceVersion2 = createStopPlace("first");
        firstStopPlaceVersion2.setVersion(2L);
        firstStopPlaceVersion2.setNetexId(firstStopPlace.getNetexId());

        firstStopPlaceVersion2 = stopPlaceRepository.save(firstStopPlaceVersion2);

        StopPlace secondStopPlace = createStopPlace("second");
        secondStopPlace.setVersion(1L);
        secondStopPlace = stopPlaceRepository.save(secondStopPlace);

        List<String> childIds = Stream.of(firstStopPlaceVersion2, secondStopPlace).map(sp -> sp.getNetexId()).collect(Collectors.toList());

        String parentStopPlaceName = "Super duper StopPlace";
        StopPlace superDuperStopPlace = multiModalStopPlaceEditor.createMultiModalParentStopPlace(childIds, new EmbeddableMultilingualString(parentStopPlaceName));

        assertThatChildsAreReferencingParentAndHasNoName(childIds, superDuperStopPlace);

        StopPlace acutalFirstStopPlace = stopPlaceRepository.findFirstByNetexIdAndVersion(firstStopPlace.getNetexId(), firstStopPlace.getVersion());
        assertThat(acutalFirstStopPlace).as("First version of first stop place should not have it's version changed").isNotNull();

        StopPlace acutalNewVersionOfFirstStopPlaceVersion2 = stopPlaceRepository.findFirstByNetexIdOrderByVersionDesc(firstStopPlace.getNetexId());
        assertThat(acutalNewVersionOfFirstStopPlaceVersion2.getVersion()).as("Previous version 2 of stop place should now be version 3").isEqualTo(3L);

        StopPlace acutalSecondStopPlace = stopPlaceRepository.findFirstByNetexIdOrderByVersionDesc(secondStopPlace.getNetexId());
        assertThat(acutalSecondStopPlace.getVersion()).as("Second stop place version should have version 2 after joining parent stop place").isEqualTo(2L);
    }

    @Test(expected = Exception.class)
    public void testNotAllowsChildStopWithFutureVersion() {

        StopPlace child = createStopPlace("child candidate");
        child.setValidBetween(new ValidBetween(Instant.now().plus(10, ChronoUnit.DAYS)));
        child = stopPlaceRepository.save(child);

        String parentStopPlaceName = "Super StopPlace";
        multiModalStopPlaceEditor.createMultiModalParentStopPlace(Arrays.asList(child.getNetexId()), new EmbeddableMultilingualString(parentStopPlaceName));
    }


    private void assertThatChildsAreReferencingParentAndHasNoName(List<String> childIds, StopPlace parent) {
        childIds.forEach(id -> {
            StopPlace child = stopPlaceRepository.findFirstByNetexIdOrderByVersionDesc(id);
            assertThat(child.getParentSiteRef()).as("child stop " + id + " must have parent site ref").isNotNull();
            assertThat(child.getParentSiteRef().getRef()).as("child stop " + id + " must have parent site ref matching matching parent's netex id").isEqualTo(parent.getNetexId());
            assertThat(child.getParentSiteRef().getVersion()).as("child stop " + id + " must have parent site ref version").isEqualTo(String.valueOf(parent.getVersion()));
            assertThat(child.getName()).as("Child should not have name set").isNull();
        });
    }


    private StopPlace createStopPlace(String name) {
        return new StopPlace(new EmbeddableMultilingualString(name));
    }
}