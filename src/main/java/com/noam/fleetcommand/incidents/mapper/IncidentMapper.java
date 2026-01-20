package com.noam.fleetcommand.incidents.mapper;

import com.noam.fleetcommand.assets.Asset;
import com.noam.fleetcommand.incidents.Incident;
import com.noam.fleetcommand.incidents.dto.IncidentRequestDto;
import com.noam.fleetcommand.incidents.dto.IncidentResponseDto;
import org.springframework.stereotype.Component;

@Component
public class IncidentMapper {

    public Incident toEntity(IncidentRequestDto request, Asset asset) {
        Incident incident = new Incident();
        incident.setAsset(asset);
        incident.setPriority(request.getPriority());
        incident.setStatus(request.getStatus());
        return incident;
    }

    public IncidentResponseDto toResponseDto(Incident incident) {
        Long assetId = incident.getAsset() != null ? incident.getAsset().getId() : null;

        return new IncidentResponseDto(
                incident.getId(),
                assetId,
                incident.getPriority(),
                incident.getStatus(),
                incident.getCreatedAt()
        );
    }
}
