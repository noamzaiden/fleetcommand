package com.noam.fleetcommand.events.dto;

import com.noam.fleetcommand.events.EventPriority;
import com.noam.fleetcommand.events.EventStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class EventResponseDto {
    private Long id;
    private Long reserveId;
    private EventPriority priority;
    private EventStatus status;
    private LocalDateTime createdAt;

    public EventResponseDto() {
    }

    public EventResponseDto(Long id, Long reserveId, EventPriority priority, EventStatus status, LocalDateTime createdAt) {
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
        EventResponseDto that = (EventResponseDto) o;
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
        return "EventResponseDto{" +
                "id=" + id +
                ", reserveId=" + reserveId +
                ", priority=" + priority +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
