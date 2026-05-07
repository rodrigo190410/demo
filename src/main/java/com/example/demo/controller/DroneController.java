package com.example.demo.controller;

import com.example.demo.dto.DroneAvailableDTO;
import com.example.demo.entities.Drone;
import com.example.demo.services.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/seedair/drones") // http://localhost:8080/seedair
public class DroneController {

    @Autowired
    private DroneService droneService;

    @GetMapping("/available") // http://localhost:8080/seedair/drones/available
    public ResponseEntity<List<DroneAvailableDTO>> getAvailableDrones() {
        List<DroneAvailableDTO> drones = droneService.getAvailableDrones();
        return new ResponseEntity<>(drones, HttpStatus.OK);
    }

}
