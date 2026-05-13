package com.example.demo.services;

import com.example.demo.dto.MaintenanceRegisterDTO;
import com.example.demo.entities.Maintenance;

public interface MaintenanceService {
    public Maintenance add(Maintenance maintenance);
    public MaintenanceRegisterDTO register(MaintenanceRegisterDTO maintenanceRegister);
}
