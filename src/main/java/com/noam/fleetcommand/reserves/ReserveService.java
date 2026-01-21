package com.noam.fleetcommand.reserves;

import com.noam.fleetcommand.reserves.dto.ReserveRequestDto;
import com.noam.fleetcommand.reserves.dto.ReserveResponseDto;
import com.noam.fleetcommand.reserves.mapper.ReserveMapper;
import com.noam.fleetcommand.common.errors.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {

    private final ReserveRepository reserveRepository;
    private final ReserveMapper reserveMapper;

    public ReserveService(ReserveRepository reserveRepository, ReserveMapper reserveMapper) {
        this.reserveRepository = reserveRepository;
        this.reserveMapper = reserveMapper;
    }

    public List<ReserveResponseDto> getAllReserves() {
        return reserveRepository.findAll()
                .stream()
                .map(reserveMapper::toResponseDto)
                .toList();
    }

    public ReserveResponseDto getReserveById(Long id) {
        Reserve reserve = reserveRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reserve not found: " + id));

        return reserveMapper.toResponseDto(reserve);
    }

    public ReserveResponseDto createReserve(ReserveRequestDto request) {
        Reserve reserve = reserveMapper.toEntity(request);
        Reserve saved = reserveRepository.save(reserve);
        return reserveMapper.toResponseDto(saved);
    }
}
