package com.noam.fleetcommand.reserves.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public AreaDto(Double minLatitude, Double maxLatitude, Double minLongitude, Double maxLongitude) {
        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
    }
}
