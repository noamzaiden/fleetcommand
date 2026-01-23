package com.noam.fleetcommand.incidents.dto;

import com.noam.fleetcommand.incidents.IncidentPriority;
import com.noam.fleetcommand.incidents.IncidentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IncidentResponseDto {
    private Long id;
    private Long reserveId;
    private IncidentPriority priority;
    private IncidentStatus status;
    private LocalDateTime createdAt;
}
