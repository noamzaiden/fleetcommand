package com.noam.fleetcommand.incidents.dto;

import com.noam.fleetcommand.incidents.IncidentPriority;
import com.noam.fleetcommand.incidents.IncidentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class IncidentResponseDto {
    private Long id;
    private Long reserveId;
    private IncidentPriority priority;
    private IncidentStatus status;
    private LocalDateTime createdAt;

    public IncidentResponseDto() {
    }

    public IncidentResponseDto(Long id, Long reserveId, IncidentPriority priority, IncidentStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.reserveId = reserveId;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncidentResponseDto that = (IncidentResponseDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(reserveId, that.reserveId) &&
                priority == that.priority &&
                status == that.status &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reserveId, priority, status, createdAt);
    }

    @Override
    public String toString() {
        return "IncidentResponseDto{" +
                "id=" + id +
                ", reserveId=" + reserveId +
                ", priority=" + priority +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
