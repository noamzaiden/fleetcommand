package com.noam.fleetcommand.reserves.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReserveResponseDto {

    private Long id;
    private String name;
    private String region;
    private AreaDto area;
    private LocalDateTime createdAt;


    public ReserveResponseDto(Long id, String name, String region, AreaDto area, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.area = area;
        this.createdAt = createdAt;
    }


}
