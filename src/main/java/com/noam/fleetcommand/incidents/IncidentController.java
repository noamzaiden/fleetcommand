package com.noam.fleetcommand.incidents;

import com.noam.fleetcommand.incidents.dto.IncidentResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping
    public ResponseEntity<List<IncidentResponseDto>> getIncidentsByAssetId(@RequestParam Long assetId) {
        List<Incident> incidents = incidentService.getIncidentsByAssetId(assetId);

        List<IncidentResponseDto> response = incidents.stream()
                .map(this::toResponseDto)
                .toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<IncidentResponseDto> createIncident(
            @RequestParam Long assetId,
            @RequestParam IncidentPriority priority,
            @RequestParam IncidentStatus status) {

        Incident created = incidentService.createIncident(assetId, priority, status);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDto(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidentResponseDto> getIncidentById(@PathVariable Long id) {
        return incidentService.getIncidentById(id)
                .map(this::toResponseDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<IncidentResponseDto> updateIncidentStatus(
            @PathVariable Long id,
            @RequestParam IncidentStatus status) {

        Incident updated = incidentService.updateStatus(id, status);
        return ResponseEntity.ok(toResponseDto(updated));
    }

    @PatchMapping("/{id}/priority")
    public ResponseEntity<IncidentResponseDto> updateIncidentPriority(
            @PathVariable Long id,
            @RequestParam IncidentPriority priority) {

        Incident updated = incidentService.updatePriority(id, priority);
        return ResponseEntity.ok(toResponseDto(updated));
    }

    private IncidentResponseDto toResponseDto(Incident incident) {
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
