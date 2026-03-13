package com.noam.fleetcommand.events.dto;

import com.noam.fleetcommand.events.EventPriority;
import com.noam.fleetcommand.events.EventStatus;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
public class EventRequestDto {

    @NotNull(message = "Reserve ID is required")
    private Long reserveId;

    @NotNull(message = "Priority is required")
    private EventPriority priority;

    @NotNull(message = "Status is required")
    private EventStatus status;

    public EventRequestDto() {
    }

    public EventRequestDto(Long reserveId, EventPriority priority, EventStatus status) {
        this.reserveId = reserveId;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventRequestDto that = (EventRequestDto) o;
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
        return "EventRequestDto{" +
                "reserveId=" + reserveId +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}
