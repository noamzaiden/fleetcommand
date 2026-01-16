package com.noam.fleetcommand.incidents;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping
    public ResponseEntity<List<Incident>> getIncidentsByAssetId(@RequestParam Long assetId) {
        List<Incident> incidents = incidentService.getIncidentsByAssetId(assetId);
        return ResponseEntity.ok(incidents);
    }


    @PostMapping
    public ResponseEntity<Incident> createIncident(
            @RequestParam Long assetId,
            @RequestParam String priority,
            @RequestParam IncidentStatus status) {

        Incident created = incidentService.createIncident(assetId, priority, status);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
        return incidentService.getIncidentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Incident> updateIncidentStatus(
            @PathVariable Long id,
            @RequestParam IncidentStatus status) {

        Incident updated = incidentService.updateStatus(id, status);
        return ResponseEntity.ok(updated);
    }

}
