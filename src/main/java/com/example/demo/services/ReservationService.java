package com.example.demo.services;

import com.example.demo.dto.ReservationByCustomerNameDTO;
import com.example.demo.dto.ReservationRangeDateDTO;
import com.example.demo.dto.ReservationRegisterDTO;
import com.example.demo.entities.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    public Reservation add(Reservation reservation);
    public List<Reservation> listAll();
    public List<ReservationRangeDateDTO> listByReservationRangeDTO(LocalDate startFilter, LocalDate endFilter);
    public List<Reservation> listByCustomerName(String name);
    public List<ReservationByCustomerNameDTO> listReservationByCustomerDTO(String name);
    public ReservationRegisterDTO registerReservation(ReservationRegisterDTO reservationRegisterDTO);
    public Reservation findById(Long id);



}
