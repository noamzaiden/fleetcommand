package com.noam.fleetcommand.incidents.dto;

import com.noam.fleetcommand.incidents.IncidentPriority;
import com.noam.fleetcommand.incidents.IncidentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentRequestDto {
    private Long reserveId;
    private IncidentPriority priority;
    private IncidentStatus status;

    public IncidentRequestDto() {
    }

    public IncidentRequestDto(Long reserveId, IncidentPriority priority, IncidentStatus status) {
        this.reserveId = reserveId;
        this.priority = priority;
        this.status = status;
    }
}
