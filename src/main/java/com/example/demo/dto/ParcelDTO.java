package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelDTO {
    private String locationText;
    private Double totalHectares;
    private Double latitude;
    private Double longitude;
}
