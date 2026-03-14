package com.noam.fleetcommand.events.dto;

import com.noam.fleetcommand.events.EventPriority;
import com.noam.fleetcommand.events.EventStatus;
import com.noam.fleetcommand.events.EventType;
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
    private EventType type;
    private String description;
    private Double latitude;
    private Double longitude;
    private Long assignedUserId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime closedAt;

    public EventResponseDto() {
    }

    public EventResponseDto(Long id, Long reserveId, EventPriority priority, EventStatus status, EventType type,
                            String description, Double latitude, Double longitude, Long assignedUserId,
                            LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime closedAt) {
        this.id = id;
        this.reserveId = reserveId;
        this.priority = priority;
        this.status = status;
        this.type = type;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.assignedUserId = assignedUserId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventResponseDto that = (EventResponseDto) o;
        return Objects.equals(id, that.id)
                && Objects.equals(reserveId, that.reserveId)
                && priority == that.priority
                && status == that.status
                && type == that.type
                && Objects.equals(description, that.description)
                && Objects.equals(latitude, that.latitude)
                && Objects.equals(longitude, that.longitude)
                && Objects.equals(assignedUserId, that.assignedUserId)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(updatedAt, that.updatedAt)
                && Objects.equals(closedAt, that.closedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reserveId, priority, status, type, description, latitude, longitude, assignedUserId,
                createdAt, updatedAt, closedAt);
    }

    @Override
    public String toString() {
        return "EventResponseDto{" +
                "id=" + id +
                ", reserveId=" + reserveId +
                ", priority=" + priority +
                ", status=" + status +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", assignedUserId=" + assignedUserId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", closedAt=" + closedAt +
                '}';
    }
}
