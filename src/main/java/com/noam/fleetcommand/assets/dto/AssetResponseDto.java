package com.noam.fleetcommand.assets.dto;

public class AssetResponseDto {

    private Long id;
    private String name;
    private Boolean trackingEnabled;

    public AssetResponseDto(Long id, String name, Boolean trackingEnabled) {
        this.id = id;
        this.name = name;
        this.trackingEnabled = trackingEnabled;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getTrackingEnabled() {
        return trackingEnabled;
    }
}
