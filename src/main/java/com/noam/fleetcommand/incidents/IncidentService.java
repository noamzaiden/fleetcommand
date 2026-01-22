package com.noam.fleetcommand.incidents;

import com.noam.fleetcommand.reserves.Reserve;
import com.noam.fleetcommand.reserves.ReserveRepository;
import com.noam.fleetcommand.common.errors.NotFoundException;
import com.noam.fleetcommand.incidents.dto.IncidentRequestDto;
import com.noam.fleetcommand.incidents.dto.IncidentResponseDto;
import com.noam.fleetcommand.incidents.mapper.IncidentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final ReserveRepository reserveRepository;
    private final IncidentMapper incidentMapper;

    public IncidentService(
            IncidentRepository incidentRepository,
            ReserveRepository reserveRepository,
            IncidentMapper incidentMapper
    ) {
        this.incidentRepository = incidentRepository;
        this.reserveRepository = reserveRepository;
        this.incidentMapper = incidentMapper;
    }

    public IncidentResponseDto createIncident(IncidentRequestDto request) {
        Reserve reserve = reserveRepository.findById(request.getReserveId())
                .orElseThrow(() -> new NotFoundException("Reserve not found: " + request.getReserveId()));

        Incident incident = incidentMapper.toEntity(request, reserve);
        Incident saved = incidentRepository.save(incident);

        return incidentMapper.toResponseDto(saved);
    }

    public List<IncidentResponseDto> getIncidentsByReserveId(Long reserveId) {
        return incidentRepository.findByReserveId(reserveId)
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
