package com.noam.fleetcommand.reserves;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

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

    public Double getMinLatitude() {
        return minLatitude;
    }

    public void setMinLatitude(Double minLatitude) {
        this.minLatitude = minLatitude;
    }

    public Double getMaxLatitude() {
        return maxLatitude;
    }

    public void setMaxLatitude(Double maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public Double getMinLongitude() {
        return minLongitude;
    }

    public void setMinLongitude(Double minLongitude) {
        this.minLongitude = minLongitude;
    }

    public Double getMaxLongitude() {
        return maxLongitude;
    }

    public void setMaxLongitude(Double maxLongitude) {
        this.maxLongitude = maxLongitude;
    }
}
