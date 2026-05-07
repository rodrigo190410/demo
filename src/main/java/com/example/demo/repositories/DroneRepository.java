package com.example.demo.repositories;

import com.example.demo.dto.DroneAvailableDTO;
import com.example.demo.entities.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DroneRepository extends JpaRepository<Drone, Long> {

    @Query("SELECT new com.example.demo.dto.DroneAvailableDTO(m.modelName, m.brand, m.seedCapacityKg, m.autonomyMinutes) " +
            "FROM Drone d JOIN d.droneModel m " +
            "WHERE d.id NOT IN (SELECT r.drone.id FROM Reservation r WHERE r.drone IS NOT NULL AND r.status IN ('PENDING', 'ON GOING'))")
    List<DroneAvailableDTO> findAvailableDronesForClient();
}
