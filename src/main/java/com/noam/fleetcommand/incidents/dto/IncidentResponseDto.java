package com.noam.fleetcommand.incidents.dto;

import com.noam.fleetcommand.incidents.IncidentPriority;
import com.noam.fleetcommand.incidents.IncidentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class IncidentResponseDto {
    private Long id;
    private Long reserveId;
    private IncidentPriority priority;
    private IncidentStatus status;
    private LocalDateTime createdAt;

    public IncidentResponseDto() {
    }

    public IncidentResponseDto(Long id, Long reserveId, IncidentPriority priority, IncidentStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.reserveId = reserveId;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
    }
}
