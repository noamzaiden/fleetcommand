package com.noam.fleetcommand.incidents;

import com.noam.fleetcommand.incidents.dto.IncidentRequestDto;
import com.noam.fleetcommand.incidents.dto.IncidentResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping
    public ResponseEntity<List<IncidentResponseDto>> getIncidents(@RequestParam(required = false) Long reserveId) {
        if (reserveId != null) {
            return ResponseEntity.ok(incidentService.getByReserveId(reserveId));
        }
        return ResponseEntity.ok(incidentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidentResponseDto> getIncidentById(@PathVariable Long id) {
        return ResponseEntity.ok(incidentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<IncidentResponseDto> createIncident(@Valid @RequestBody IncidentRequestDto request) {
        IncidentResponseDto created = incidentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<IncidentResponseDto> updateIncidentStatus(
            @PathVariable Long id,
            @RequestParam IncidentStatus status
    ) {
        return ResponseEntity.ok(incidentService.updateStatus(id, status));
    }

    @PatchMapping("/{id}/priority")
    public ResponseEntity<IncidentResponseDto> updateIncidentPriority(
            @PathVariable Long id,
            @RequestParam IncidentPriority priority
    ) {
        return ResponseEntity.ok(incidentService.updatePriority(id, priority));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        incidentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
