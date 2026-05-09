package com.example.demo.services;

import com.example.demo.dto.DroneAvailableDTO;
import com.example.demo.dto.DroneDTO;
import com.example.demo.entities.Drone;

import java.util.List;

public interface DroneService {

    public Drone addDrone(Drone drone);
    //public DroneAvailableDTO addDroneAvailableDTO(DroneAvailableDTO droneAvailableDTO);
    public List<DroneAvailableDTO> getAvailableDrones();
    public Drone addDTO(DroneDTO dto);
    public Drone findById(Long id);
    public List<Drone> getDronesByStatus(String status);
    void delete(Long id);
}
