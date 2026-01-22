package com.noam.fleetcommand.incidents.mapper;

import com.noam.fleetcommand.reserves.Reserve;
import com.noam.fleetcommand.incidents.Incident;
import com.noam.fleetcommand.incidents.dto.IncidentRequestDto;
import com.noam.fleetcommand.incidents.dto.IncidentResponseDto;
import org.springframework.stereotype.Component;

@Component
public class IncidentMapper {

    public Incident toEntity(IncidentRequestDto request, Reserve reserve) {
        Incident incident = new Incident();
        incident.setReserve(reserve);
        incident.setPriority(request.getPriority());
        incident.setStatus(request.getStatus());
        return incident;
    }

    public IncidentResponseDto toResponseDto(Incident incident) {
        Long reserveId = incident.getReserve() != null ? incident.getReserve().getId() : null;

        return new IncidentResponseDto(
                incident.getId(),
                reserveId,
                incident.getPriority(),
                incident.getStatus(),
                incident.getCreatedAt()
        );
    }
}
