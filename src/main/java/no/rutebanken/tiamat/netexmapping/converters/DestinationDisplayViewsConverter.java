package no.rutebanken.tiamat.netexmapping.converters;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import no.rutebanken.netex.model.CheckConstraints_RelStructure;
import no.rutebanken.netex.model.DestinationDisplayViews_RelStructure;
import no.rutebanken.tiamat.model.CheckConstraint;
import no.rutebanken.tiamat.model.DestinationDisplayView;

import java.util.List;

public class DestinationDisplayViewsConverter extends BidirectionalConverter<List<DestinationDisplayView>, DestinationDisplayViews_RelStructure> {

    @Override
    public DestinationDisplayViews_RelStructure convertTo(List<DestinationDisplayView> destinationDisplayViews, Type<DestinationDisplayViews_RelStructure> type) {
        return null;
    }

    @Override
    public List<DestinationDisplayView> convertFrom(DestinationDisplayViews_RelStructure destinationDisplayViews_relStructure, Type<List<DestinationDisplayView>> type) {
        return null;
    }
}