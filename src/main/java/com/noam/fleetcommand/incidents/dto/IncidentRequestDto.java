package com.noam.fleetcommand.incidents.dto;

import com.noam.fleetcommand.incidents.IncidentPriority;
import com.noam.fleetcommand.incidents.IncidentStatus;
import jakarta.validation.constraints.NotNull;

public class IncidentRequestDto {

    @NotNull(message = "reserveId is required")
    private Long reserveId;

    @NotNull(message = "priority is required")
    private IncidentPriority priority;

    @NotNull(message = "status is required")
    private IncidentStatus status;

    public IncidentRequestDto() {

    }

    public IncidentRequestDto(Long reserveId, IncidentPriority priority, IncidentStatus status) {
        this.reserveId = reserveId;
        this.priority = priority;
        this.status = status;
    }

    public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
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
