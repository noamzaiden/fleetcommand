package com.noam.fleetcommand.incidents.dto;

import com.noam.fleetcommand.incidents.IncidentPriority;
import com.noam.fleetcommand.incidents.IncidentStatus;

import java.time.LocalDateTime;

public class IncidentResponseDto {

    private Long id;
    private Long reserveId;
    private IncidentPriority priority;
    private IncidentStatus status;
    private LocalDateTime createdAt;

    public IncidentResponseDto(Long id, Long reserveId, IncidentPriority priority, IncidentStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.reserveId = reserveId;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getReserveId() {
        return reserveId;
    }

    public IncidentPriority getPriority() {
        return priority;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
