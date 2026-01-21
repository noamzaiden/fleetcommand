package com.noam.fleetcommand.reserves.dto;

public class ReserveResponseDto {

    private Long id;
    private String name;
    private Boolean trackingEnabled;

    public ReserveResponseDto(Long id, String name, Boolean trackingEnabled) {
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
