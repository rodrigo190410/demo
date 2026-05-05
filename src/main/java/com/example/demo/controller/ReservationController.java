package com.example.demo.controller;

import com.example.demo.dto.ReservationByCustomerDTO;
import com.example.demo.dto.ReservationRangeDateDTO;
import com.example.demo.dto.ReservationRegisterDTO;
import com.example.demo.entities.Reservation;
import com.example.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/seedair") // http://localhost:8080/seedair
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    //El customer registra una reserva
    @PostMapping("/reservations/register") // http://localhost:8080/seedair/reservations/register
    ResponseEntity<ReservationRegisterDTO> registerReservation(
            @RequestBody ReservationRegisterDTO reservationRegisterDTO
    ){
        ReservationRegisterDTO newRegister = reservationService.registerReservation(reservationRegisterDTO);
        return new ResponseEntity<>(newRegister, HttpStatus.OK);
    }
    //Lista general de reservas -> temp
    @GetMapping("/reservations") // http://localhost:8080/seedair/reservations
    ResponseEntity<List<Reservation>> listAll(){
      List<Reservation> reservationList = reservationService.listAll();
        return new ResponseEntity<>(reservationList, HttpStatus.OK);
    };

    //Lista de reservas en rango de fechas
    @GetMapping("/reservations/{startFilter}/{endFilter}") // http://localhost:8080/seedair/reservations/{startFilter}/{endFilter}
    ResponseEntity<List<ReservationRangeDateDTO>> listByRangeDate(
            @PathVariable LocalDate startFilter,
            @PathVariable LocalDate endFilter
            ){
        List<ReservationRangeDateDTO> newList = reservationService.listByReservationRangeDTO(startFilter, endFilter);
        return new ResponseEntity<>(newList, HttpStatus.OK);
    };

    //Lista de reservas por primer nombre cliente
    @GetMapping("/reservations/{name}") // http://localhost:8080/seedair/reservations/{name}
    ResponseEntity<List<ReservationByCustomerDTO>> listReservationsByCustomerName(@PathVariable String name){
     List<ReservationByCustomerDTO> newList = reservationService.listReservationByCustomerDTO(name);
     return new ResponseEntity<>(newList, HttpStatus.OK);
    }

}
