package com.noam.fleetcommand.incidents.dto;

import com.noam.fleetcommand.incidents.IncidentPriority;
import com.noam.fleetcommand.incidents.IncidentStatus;

public class IncidentRequestDto {

    private Long assetId;
    private IncidentPriority priority;
    private IncidentStatus status;

    public IncidentRequestDto() {

    }

    public IncidentRequestDto(Long assetId, IncidentPriority priority, IncidentStatus status) {
        this.assetId = assetId;
        this.priority = priority;
        this.status = status;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public IncidentPriority getPriority() {
        return priority;
    }

    public void setPriority(IncidentPriority priority) {
        this.priority = priority;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }
}
