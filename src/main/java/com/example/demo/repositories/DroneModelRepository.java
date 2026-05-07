package com.example.demo.repositories;

import com.example.demo.entities.DroneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneModelRepository extends JpaRepository<DroneModel, Long> {

}
