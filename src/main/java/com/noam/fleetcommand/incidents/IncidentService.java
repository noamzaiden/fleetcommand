package com.noam.fleetcommand.incidents;

import com.noam.fleetcommand.assets.Asset;
import com.noam.fleetcommand.assets.AssetRepository;
import com.noam.fleetcommand.incidents.dto.IncidentRequestDto;
import com.noam.fleetcommand.incidents.dto.IncidentResponseDto;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final AssetRepository assetRepository;

    public IncidentService(IncidentRepository incidentRepository, AssetRepository assetRepository) {
        this.incidentRepository = incidentRepository;
        this.assetRepository = assetRepository;
    }

    public IncidentResponseDto createIncident(IncidentRequestDto request) {
        Long assetId = request.getAssetId();

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new IllegalArgumentException("Asset not found: " + assetId));

        Incident incident = new Incident();
        incident.setAsset(asset);
        incident.setPriority(request.getPriority());
        incident.setStatus(request.getStatus());

        Incident saved = incidentRepository.save(incident);

        return new IncidentResponseDto(
                saved.getId(),
                saved.getAsset().getId(),
                saved.getPriority(),
                saved.getStatus(),
                saved.getCreatedAt()
        );
    }


    public List<Incident> getIncidentsByAssetId(Long assetId) {
        return incidentRepository.findByAssetId(assetId);
    }


    public Optional<Incident> getIncidentById(Long id) {
        return incidentRepository.findById(id);
    }

    public Incident updateStatus(Long incidentId, IncidentStatus status) {
        Incident incident = incidentRepository.findById(incidentId)
                .orElseThrow(() -> new IllegalArgumentException("Incident not found: " + incidentId));

        incident.setStatus(status);
        return incidentRepository.save(incident);
    }
    public Incident updatePriority(Long incidentId, IncidentPriority priority) {
        Incident incident = incidentRepository.findById(incidentId)
                .orElseThrow(() -> new IllegalArgumentException("Incident not found: " + incidentId));

        incident.setPriority(priority);
        return incidentRepository.save(incident);
    }



}
