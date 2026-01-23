package com.noam.fleetcommand.reserves.dto;

import jakarta.validation.constraints.NotNull;

public class AreaDto {

    @NotNull
    private Double minLatitude;

    @NotNull
    private Double maxLatitude;

    @NotNull
    private Double minLongitude;

    @NotNull
    private Double maxLongitude;

    public AreaDto() {
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
