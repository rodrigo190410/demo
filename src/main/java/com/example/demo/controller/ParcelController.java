package com.example.demo.controller;

import com.example.demo.dto.ParcelDTO;
import com.example.demo.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/seedair")
public class ParcelController {
    @Autowired
    ParcelService parcelService;

    //registro nueva parcela ->para el cliente
    @PostMapping("/parcels/register") // http://localhost:8080/parcels/register
    public ResponseEntity<ParcelDTO> register(@RequestBody ParcelDTO parcelDTO, Long customerId){
        ParcelDTO newParcel = parcelService.register(parcelDTO);
        return new ResponseEntity<>(newParcel, HttpStatus.CREATED);
    }
}
