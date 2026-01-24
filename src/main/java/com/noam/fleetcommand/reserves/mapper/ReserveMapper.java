package com.noam.fleetcommand.reserves.mapper;

import com.noam.fleetcommand.reserves.Area;
import com.noam.fleetcommand.reserves.Reserve;
import com.noam.fleetcommand.reserves.dto.AreaDto;
import com.noam.fleetcommand.reserves.dto.ReserveRequestDto;
import com.noam.fleetcommand.reserves.dto.ReserveResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReserveMapper {

    ReserveResponseDto toResponseDto(Reserve reserve);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Reserve toEntity(ReserveRequestDto dto);

    AreaDto toAreaDto(Area area);

    Area toAreaEntity(AreaDto dto);
}
