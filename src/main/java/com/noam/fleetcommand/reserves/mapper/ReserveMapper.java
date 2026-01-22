package com.noam.fleetcommand.reserves.mapper;

import com.noam.fleetcommand.reserves.Reserve;
import com.noam.fleetcommand.reserves.dto.ReserveRequestDto;
import com.noam.fleetcommand.reserves.dto.ReserveResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ReserveMapper {

    public Reserve toEntity(ReserveRequestDto request) {
        Reserve reserve = new Reserve();
        reserve.setName(request.getName());
        reserve.setTrackingEnabled(request.getTrackingEnabled());
        return reserve;
    }

    public ReserveResponseDto toResponseDto(Reserve reserve) {
        return new ReserveResponseDto(reserve.getId(), reserve.getName(), reserve.getTrackingEnabled());
    }
}
