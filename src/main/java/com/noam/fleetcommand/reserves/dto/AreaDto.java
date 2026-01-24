package com.noam.fleetcommand.reserves.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}
