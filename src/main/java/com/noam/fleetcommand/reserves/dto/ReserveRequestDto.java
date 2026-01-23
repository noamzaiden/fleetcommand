package com.noam.fleetcommand.reserves.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;


public class ReserveRequestDto {

    @NotBlank
    private String name;

    private String region;

    @NotNull
    @Valid
    private AreaDto area;


    public ReserveRequestDto(){

    }

    public ReserveRequestDto(String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }

}
