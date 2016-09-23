package no.rutebanken.tiamat.importers;

import no.rutebanken.tiamat.model.SiteFrame;
import no.rutebanken.tiamat.model.StopPlace;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public interface StopPlaceImporter {
    StopPlace importStopPlace(StopPlace stopPlace, SiteFrame siteFrame,
                              AtomicInteger topographicPlacesCreatedCounter) throws InterruptedException, ExecutionException;
}