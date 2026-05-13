package com.example.demo.serviceimpl;

import com.example.demo.dto.DroneModelDTO;
import com.example.demo.entities.DroneModel;
import com.example.demo.repositories.DroneModelRepository;
import com.example.demo.services.DroneModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneModelServiceImpl implements DroneModelService {


    @Autowired
    private DroneModelRepository droneModelRepository;

    @Override
    public DroneModel addDroneModel(DroneModel droneModel) {
        return droneModelRepository.save(droneModel);
    }

    @Override
    public DroneModel addDTO(DroneModelDTO dto) {
        DroneModel model= new DroneModel();
        model.setModelName(dto.getName());
        model.setBrand(dto.getBrand());
        model.setSeedCapacityKg(dto.getSeedCapacityKg());
        model.setAutonomyMinutes(dto.getAutonomyMinutes());
        return droneModelRepository.save(model);
    }
}
