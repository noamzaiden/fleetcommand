package com.noam.fleetcommand.events.mapper;

import com.noam.fleetcommand.events.Event;
import com.noam.fleetcommand.events.dto.EventRequestDto;
import com.noam.fleetcommand.events.dto.EventResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(source = "reserve.id", target = "reserveId")
    EventResponseDto toDto(Event event);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "reserve", ignore = true)
    Event toEntity(EventRequestDto dto);
}
