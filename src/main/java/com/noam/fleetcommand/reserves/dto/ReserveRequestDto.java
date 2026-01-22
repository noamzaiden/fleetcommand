package com.noam.fleetcommand.reserves.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ReserveRequestDto {

    @NotBlank
    private String name;
    @NotNull
    private Boolean trackingEnabled;


    public ReserveRequestDto(){

    }

    public ReserveRequestDto(String name, Boolean trackingEnabled) {
        this.name = name;
        this.trackingEnabled = trackingEnabled;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setTrackingEnabled(Boolean trackingEnabled){
        this.trackingEnabled=trackingEnabled;
    }

    public Boolean getTrackingEnabled() {
        return trackingEnabled;
    }
}
