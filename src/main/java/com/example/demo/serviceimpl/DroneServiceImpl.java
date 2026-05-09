package com.example.demo.serviceimpl;

import com.example.demo.dto.DroneAvailableDTO;
import com.example.demo.dto.DroneDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entities.Drone;
import com.example.demo.entities.DroneModel;
import com.example.demo.repositories.DroneModelRepository;
import com.example.demo.repositories.DroneRepository;
import com.example.demo.services.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DroneServiceImpl implements DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private DroneModelRepository droneModelRepository;

    @Override
    public Drone addDrone(Drone drone) {return droneRepository.save(drone);}


    @Override
    public List<DroneAvailableDTO> getAvailableDrones() {
        return droneRepository.findAvailableDronesForClient();
    }

    @Override
    public Drone addDTO(DroneDTO dto) {
        // 1. Buscamos el modelo que indicaste en el DTO
        DroneModel model = droneModelRepository.findById(dto.getDroneModelId())
                .orElseThrow(() -> new RuntimeException("Modelo no encontrado"));
        // 2. Creamos la entidad Drone y mapeamos
        Drone drone = new Drone();
        drone.setSerialNumber(dto.getSerialNumber());
        drone.setDroneModel(model); // Aquí se hace la relación
        drone.setCurrentStatus("ACTIVE"); // Estado inicial por defecto
        return droneRepository.save(drone);
    }

    @Override
    public Drone findById(Long id) {
        return droneRepository.findById(id).orElse(null);
    }

    @Override
    public List<Drone> getDronesByStatus(String status) {
        return droneRepository.findByCurrentStatus(status);
    }

    @Override
    public void delete(Long id) {
        if (!droneRepository.existsById(id)) {
            throw new NoSuchElementException("No se encontro el drone con ese id:" + id);
        }
        droneRepository.deleteById(id);
    }


}
