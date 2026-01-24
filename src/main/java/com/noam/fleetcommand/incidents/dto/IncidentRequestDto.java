package com.noam.fleetcommand.incidents.dto;

import com.noam.fleetcommand.incidents.IncidentPriority;
import com.noam.fleetcommand.incidents.IncidentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class IncidentRequestDto {
    private Long reserveId;
    private IncidentPriority priority;
    private IncidentStatus status;

    public IncidentRequestDto() {
    }

    public IncidentRequestDto(Long reserveId, IncidentPriority priority, IncidentStatus status) {
        this.reserveId = reserveId;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncidentRequestDto that = (IncidentRequestDto) o;
        return Objects.equals(reserveId, that.reserveId) &&
                priority == that.priority &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reserveId, priority, status);
    }

    @Override
    public String toString() {
        return "IncidentRequestDto{" +
                "reserveId=" + reserveId +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}
