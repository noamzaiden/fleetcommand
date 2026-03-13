package com.noam.fleetcommand.events;

import com.noam.fleetcommand.reserves.Reserve;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserve_id", nullable = false)
    private Reserve reserve;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventPriority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventStatus status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Updated constructor for creating a new Event.
     * Fields managed by the database (id, createdAt) are excluded to ensure data integrity.
     */
    public Event(Reserve reserve, EventPriority priority, EventStatus status) {
        this.reserve = reserve;
        this.priority = priority;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reserve getReserve() {
        return reserve;
    }

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }

    public EventPriority getPriority() {
        return priority;
    }

    public void setPriority(EventPriority priority) {
        this.priority = priority;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", priority=" + priority +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
