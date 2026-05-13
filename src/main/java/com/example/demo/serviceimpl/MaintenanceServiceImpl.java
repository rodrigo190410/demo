package com.example.demo.serviceimpl;

import com.example.demo.dto.MaintenanceRegisterDTO;
import com.example.demo.entities.Drone;
import com.example.demo.entities.Maintenance;
import com.example.demo.repositories.MaintenanceRepository;
import com.example.demo.services.DroneService;
import com.example.demo.services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    @Autowired
    MaintenanceRepository maintenanceRepository;
    @Autowired
    DroneService droneService;

    @Override
    public Maintenance add(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public MaintenanceRegisterDTO register(MaintenanceRegisterDTO maintenanceRegister) {
        Drone drone = droneService.findById(maintenanceRegister.getDroneId());
        Maintenance newMaintenance = new Maintenance(
                null, maintenanceRegister.getStartDate(),null,
                maintenanceRegister.getStatus(),maintenanceRegister.getDescription(),
                maintenanceRegister.getCost(), drone
        );
        maintenanceRepository.save(newMaintenance);
        return maintenanceRegister;
    }
}
