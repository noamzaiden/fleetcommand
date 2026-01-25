package com.noam.fleetcommand.reserves.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ReserveRequestDto {

    @NotBlank
    private String name;

    private String region;

    @NotNull
    @Valid
    private AreaDto area;

    public ReserveRequestDto() {
    }

    public ReserveRequestDto(String name, String region, AreaDto area) {
        this.name = name;
        this.region = region;
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReserveRequestDto that = (ReserveRequestDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(region, that.region) &&
                Objects.equals(area, that.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, area);
    }

    @Override
    public String toString() {
        return "ReserveRequestDto{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", area=" + area +
                '}';
    }
}
