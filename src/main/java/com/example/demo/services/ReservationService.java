package com.example.demo.services;

import com.example.demo.dto.ReservationByCustomerNameDTO;
import com.example.demo.dto.ReservationRangeDateDTO;
import com.example.demo.dto.ReservationRegisterDTO;
import com.example.demo.dto.SetReservationStatusDTO;
import com.example.demo.entities.Reservation;
import com.example.demo.dto.ReservationByStatusDTO;

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
    public List<Reservation> listByStatus(String status);
    public List<ReservationByStatusDTO> listByStatusDTO(String status);
    public SetReservationStatusDTO updateStatus(SetReservationStatusDTO updatedStatus);

    List<Reservation> getReservationsByUsername(String username);
    //funcionalidad para eliminar una reserva, como admin
    void delete(Long id);




}
