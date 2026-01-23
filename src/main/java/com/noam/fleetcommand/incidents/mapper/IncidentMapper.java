package com.noam.fleetcommand.incidents.mapper;

import com.noam.fleetcommand.incidents.Incident;
import com.noam.fleetcommand.incidents.dto.IncidentRequestDto;
import com.noam.fleetcommand.incidents.dto.IncidentResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IncidentMapper {

    @Mapping(source = "reserve.id", target = "reserveId")
    IncidentResponseDto toDto(Incident incident);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "reserve", ignore = true)
    Incident toEntity(IncidentRequestDto dto);
}
