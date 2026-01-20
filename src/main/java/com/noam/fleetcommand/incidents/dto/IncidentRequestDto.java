package com.noam.fleetcommand.incidents.dto;

import com.noam.fleetcommand.incidents.IncidentPriority;
import com.noam.fleetcommand.incidents.IncidentStatus;
import jakarta.validation.constraints.NotNull;

public class IncidentRequestDto {

    @NotNull(message = "assetId is required")
    private Long assetId;

    @NotNull(message = "priority is required")
    private IncidentPriority priority;

    @NotNull(message = "status is required")
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
