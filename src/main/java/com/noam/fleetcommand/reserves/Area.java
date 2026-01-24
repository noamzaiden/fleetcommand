package com.noam.fleetcommand.reserves;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Area {

    @Column(name = "min_latitude", nullable = false)
    private Double minLatitude;

    @Column(name = "max_latitude", nullable = false)
    private Double maxLatitude;

    @Column(name = "min_longitude", nullable = false)
    private Double minLongitude;

    @Column(name = "max_longitude", nullable = false)
    private Double maxLongitude;

    public Area() {
    }

}
