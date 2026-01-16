package com.noam.fleetcommand.assets.dto;

public class AssetRequestDto {

    private String name;
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
