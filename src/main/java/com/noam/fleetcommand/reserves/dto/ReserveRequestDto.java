package com.noam.fleetcommand.reserves.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReserveRequestDto {

    @NotBlank
    private String name;

    private String region;

    @NotNull
    @Valid
    private AreaDto area;

    public ReserveRequestDto() {
    }

    public ReserveRequestDto(String name, String region, AreaDto area) {
        this.name = name;
        this.region = region;
        this.area = area;
    }
}
