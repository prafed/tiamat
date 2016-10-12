package org.rutebanken.tiamat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.rutebanken.tiamat.model.Quay;

public interface QuayRepositoryCustom {

    Quay findQuayDetailed(Long quayId);
    
    Page<Quay> findQuaysWithin(double xMin, double yMin, double xMax, double yMax, Pageable pageable);
}