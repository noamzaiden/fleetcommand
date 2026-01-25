package com.noam.fleetcommand.reserves;

import com.noam.fleetcommand.common.errors.NotFoundException;
import com.noam.fleetcommand.reserves.dto.ReserveRequestDto;
import com.noam.fleetcommand.reserves.dto.ReserveResponseDto;
import com.noam.fleetcommand.reserves.mapper.ReserveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReserveService {

    private final ReserveRepository reserveRepository;
    private final ReserveMapper reserveMapper;

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

    @Transactional
    public ReserveResponseDto createReserve(ReserveRequestDto request) {
        Reserve reserve = reserveMapper.toEntity(request);
        Reserve saved = reserveRepository.save(reserve);
        return reserveMapper.toResponseDto(saved);
    }
}
