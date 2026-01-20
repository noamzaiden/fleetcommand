package com.noam.fleetcommand.incidents;

import com.noam.fleetcommand.assets.Asset;
import com.noam.fleetcommand.assets.AssetRepository;
import com.noam.fleetcommand.common.errors.NotFoundException;
import com.noam.fleetcommand.incidents.dto.IncidentRequestDto;
import com.noam.fleetcommand.incidents.dto.IncidentResponseDto;
import com.noam.fleetcommand.incidents.mapper.IncidentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final AssetRepository assetRepository;
    private final IncidentMapper incidentMapper;

    public IncidentService(
            IncidentRepository incidentRepository,
            AssetRepository assetRepository,
            IncidentMapper incidentMapper
    ) {
        this.incidentRepository = incidentRepository;
        this.assetRepository = assetRepository;
        this.incidentMapper = incidentMapper;
    }

    public IncidentResponseDto createIncident(IncidentRequestDto request) {
        Asset asset = assetRepository.findById(request.getAssetId())
                .orElseThrow(() -> new NotFoundException("Asset not found: " + request.getAssetId()));

        Incident incident = incidentMapper.toEntity(request, asset);
        Incident saved = incidentRepository.save(incident);

        return incidentMapper.toResponseDto(saved);
    }

    public List<IncidentResponseDto> getIncidentsByAssetId(Long assetId) {
        return incidentRepository.findByAssetId(assetId)
                .stream()
                .map(incidentMapper::toResponseDto)
                .toList();
    }

    public IncidentResponseDto getIncidentById(Long id) {
        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Incident not found: " + id));

        return incidentMapper.toResponseDto(incident);
    }

    public IncidentResponseDto updateStatus(Long incidentId, IncidentStatus status) {
        Incident incident = incidentRepository.findById(incidentId)
                .orElseThrow(() -> new NotFoundException("Incident not found: " + incidentId));

        incident.setStatus(status);
        Incident saved = incidentRepository.save(incident);

        return incidentMapper.toResponseDto(saved);
    }

    public IncidentResponseDto updatePriority(Long incidentId, IncidentPriority priority) {
        Incident incident = incidentRepository.findById(incidentId)
                .orElseThrow(() -> new NotFoundException("Incident not found: " + incidentId));

        incident.setPriority(priority);
        Incident saved = incidentRepository.save(incident);

        return incidentMapper.toResponseDto(saved);
    }
}
