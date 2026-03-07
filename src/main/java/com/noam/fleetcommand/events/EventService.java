package com.noam.fleetcommand.events;

import com.noam.fleetcommand.common.errors.NotFoundException;
import com.noam.fleetcommand.events.dto.EventRequestDto;
import com.noam.fleetcommand.events.dto.EventResponseDto;
import com.noam.fleetcommand.events.mapper.EventMapper;
import com.noam.fleetcommand.reserves.Reserve;
import com.noam.fleetcommand.reserves.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final ReserveRepository reserveRepository;
    private final EventMapper eventMapper;

    @Transactional
    public EventResponseDto create(EventRequestDto requestDto) {
        Event event = eventMapper.toEntity(requestDto);
        
        Reserve reserve = reserveRepository.findById(requestDto.getReserveId())
                .orElseThrow(() -> new NotFoundException("Reserve not found with id: " + requestDto.getReserveId()));
        
        event.setReserve(reserve);
        
        Event savedEvent = eventRepository.save(event);
        return eventMapper.toDto(savedEvent);
    }

    public EventResponseDto getById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found with id: " + id));
        return eventMapper.toDto(event);
    }

    public List<EventResponseDto> getAll() {
        return eventRepository.findAll().stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<EventResponseDto> getByReserveId(Long reserveId) {
        return eventRepository.findByReserveId(reserveId).stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public EventResponseDto updateStatus(Long id, EventStatus status) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found with id: " + id));
        event.setStatus(status);
        return eventMapper.toDto(eventRepository.save(event));
    }

    @Transactional
    public EventResponseDto updatePriority(Long id, EventPriority priority) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found with id: " + id));
        event.setPriority(priority);
        return eventMapper.toDto(eventRepository.save(event));
    }
    
    @Transactional
    public void delete(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new NotFoundException("Event not found with id: " + id);
        }
        eventRepository.deleteById(id);
    }
}
