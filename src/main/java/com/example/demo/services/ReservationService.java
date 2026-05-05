package com.example.demo.services;

import com.example.demo.dto.ReservationByCustomerDTO;
import com.example.demo.dto.ReservationRangeDateDTO;
import com.example.demo.dto.ReservationRegisterDTO;
import com.example.demo.entities.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    Reservation add(Reservation reservation);
    List<Reservation> listAll();
    List<ReservationRangeDateDTO> listByReservationRangeDTO(LocalDate startFilter, LocalDate endFilter);

    List<Reservation> listByCustomerName(String name);
    List<ReservationByCustomerDTO> listReservationByCustomerDTO(String name);

    ReservationRegisterDTO registerReservation(ReservationRegisterDTO reservationRegisterDTO);

    Reservation findById(Long id);



}
