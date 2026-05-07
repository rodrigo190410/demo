package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneModelDTO {

    private String name;
    private String brand;
    private Double seedCapacityKg;
    private Integer autonomyMinutes;
}
