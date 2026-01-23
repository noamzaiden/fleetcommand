package com.noam.fleetcommand.incidents.dto;

import com.noam.fleetcommand.incidents.IncidentPriority;
import com.noam.fleetcommand.incidents.IncidentStatus;
import lombok.Data;

@Data
public class IncidentRequestDto {
    private Long reserveId;
    private IncidentPriority priority;
    private IncidentStatus status;
}
