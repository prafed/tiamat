package org.rutebanken.tiamat.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PlaceRefStructure extends GroupOfEntitiesRefStructure {

    public PlaceRefStructure() {
        super();
    }

    public PlaceRefStructure(String ref, String version) {
        super(ref, version);
    }
}
