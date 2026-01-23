package com.noam.fleetcommand.incidents;

import com.noam.fleetcommand.common.errors.NotFoundException;
import com.noam.fleetcommand.incidents.dto.IncidentRequestDto;
import com.noam.fleetcommand.incidents.dto.IncidentResponseDto;
import com.noam.fleetcommand.incidents.mapper.IncidentMapper;
import com.noam.fleetcommand.reserves.Reserve;
import com.noam.fleetcommand.reserves.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final ReserveRepository reserveRepository;
    private final IncidentMapper incidentMapper;

    @Transactional
    public IncidentResponseDto create(IncidentRequestDto requestDto) {
        Incident incident = incidentMapper.toEntity(requestDto);
        
        Reserve reserve = reserveRepository.findById(requestDto.getReserveId())
                .orElseThrow(() -> new NotFoundException("Reserve not found with id: " + requestDto.getReserveId()));
        
        incident.setReserve(reserve);
        
        Incident savedIncident = incidentRepository.save(incident);
        return incidentMapper.toDto(savedIncident);
    }

    public IncidentResponseDto getById(Long id) {
        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Incident not found with id: " + id));
        return incidentMapper.toDto(incident);
    }

    public List<IncidentResponseDto> getAll() {
        return incidentRepository.findAll().stream()
                .map(incidentMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<IncidentResponseDto> getByReserveId(Long reserveId) {
        return incidentRepository.findByReserveId(reserveId).stream()
                .map(incidentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public IncidentResponseDto updateStatus(Long id, IncidentStatus status) {
        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Incident not found with id: " + id));
        incident.setStatus(status);
        return incidentMapper.toDto(incidentRepository.save(incident));
    }

    @Transactional
    public IncidentResponseDto updatePriority(Long id, IncidentPriority priority) {
        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Incident not found with id: " + id));
        incident.setPriority(priority);
        return incidentMapper.toDto(incidentRepository.save(incident));
    }
    
    @Transactional
    public void delete(Long id) {
        if (!incidentRepository.existsById(id)) {
            throw new NotFoundException("Incident not found with id: " + id);
        }
        incidentRepository.deleteById(id);
    }
}
