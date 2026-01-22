package com.noam.fleetcommand.incidents;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findByReserveId(Long reserveId);

}
