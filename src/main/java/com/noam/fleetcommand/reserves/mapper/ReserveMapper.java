package com.noam.fleetcommand.reserves.mapper;

import com.noam.fleetcommand.reserves.Reserve;
import com.noam.fleetcommand.reserves.dto.ReserveRequestDto;
import com.noam.fleetcommand.reserves.dto.ReserveResponseDto;
import org.springframework.stereotype.Component;
import com.noam.fleetcommand.reserves.Area;
import com.noam.fleetcommand.reserves.dto.AreaDto;

@Component
public class ReserveMapper {

    public Reserve toEntity(ReserveRequestDto request) {
        Reserve reserve = new Reserve();
        reserve.setName(request.getName());
        reserve.setRegion(request.getRegion());
        reserve.setArea(toAreaEntity(request.getArea()));
        return reserve;
    }


    public ReserveResponseDto toResponseDto(Reserve reserve) {
        return new ReserveResponseDto(
                reserve.getId(),
                reserve.getName(),
                reserve.getRegion(),
                toAreaDto(reserve.getArea()),
                reserve.getCreatedAt()
        );
    }

    private Area toAreaEntity(AreaDto dto) {
        if (dto == null) return null;

        Area area = new Area();
        area.setMinLatitude(dto.getMinLatitude());
        area.setMaxLatitude(dto.getMaxLatitude());
        area.setMinLongitude(dto.getMinLongitude());
        area.setMaxLongitude(dto.getMaxLongitude());
        return area;
    }

    private AreaDto toAreaDto(Area area) {
        if (area == null) return null;

        AreaDto dto = new AreaDto();
        dto.setMinLatitude(area.getMinLatitude());
        dto.setMaxLatitude(area.getMaxLatitude());
        dto.setMinLongitude(area.getMinLongitude());
        dto.setMaxLongitude(area.getMaxLongitude());
        return dto;
    }

}
