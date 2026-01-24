package com.noam.fleetcommand.reserves.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class ReserveResponseDto {
    private Long id;
    private String name;
    private String region;
    private AreaDto area;
    private LocalDateTime createdAt;

    public ReserveResponseDto() {
    }

    public ReserveResponseDto(Long id, String name, String region, AreaDto area, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.area = area;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReserveResponseDto that = (ReserveResponseDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(region, that.region) &&
                Objects.equals(area, that.area) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, region, area, createdAt);
    }

    @Override
    public String toString() {
        return "ReserveResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", area=" + area +
                ", createdAt=" + createdAt +
                '}';
    }
}
