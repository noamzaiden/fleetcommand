package com.noam.fleetcommand.assets.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class AssetRequestDto {

    @NotBlank
    private String name;
    @NotNull
    private Boolean trackingEnabled;


    public AssetRequestDto(){

    }

    public AssetRequestDto(String name, Boolean trackingEnabled) {
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
