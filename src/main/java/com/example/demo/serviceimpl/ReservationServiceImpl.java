package com.example.demo.serviceimpl;

import com.example.demo.dto.ReservationByCustomerDTO;
import com.example.demo.dto.ReservationRangeDateDTO;
import com.example.demo.dto.ReservationRegisterDTO;
import com.example.demo.entities.Parcel;
import com.example.demo.entities.Reservation;
import com.example.demo.repositories.ReservationRepository;
import com.example.demo.services.CustomerService;
import com.example.demo.services.ParcelService;
import com.example.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    ParcelService parcelService;

    @Override
    public Reservation add(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> listAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<ReservationRangeDateDTO> listByReservationRangeDTO(LocalDate startFilter, LocalDate endFilter) {
        List<Reservation> reservationList = reservationRepository.findByScheduledStartDateBetween(startFilter, endFilter);
        List<ReservationRangeDateDTO> reservationRangeDateDTOList = new ArrayList<>();

        for (Reservation r:reservationList){

            reservationRangeDateDTOList.add(new ReservationRangeDateDTO(
                    r.getId(), r.getScheduledStartDate(), r.getHectares(),r.getTotalAmount(),
                    r.getStatus()
            ));
        }

        return reservationRangeDateDTOList;
    }

    @Override
    public List<Reservation> listByCustomerName(String name) {
        return reservationRepository.findByCustomerName(name);
    }

    @Override
    public List<ReservationByCustomerDTO> listReservationByCustomerDTO(String name) {
        List<Reservation> reservationList = listByCustomerName(name);
        List<ReservationByCustomerDTO> reservationDTOList = new ArrayList<>();

        for (Reservation r: reservationList){
            reservationDTOList.add(new ReservationByCustomerDTO(
                    r.getId(), r.getScheduledStartDate(), r.getScheduledEndDate(),
                    r.getCustomer().getId(), r.getCustomer().getFirstName(),
                    r.getCustomer().getLastName()
            ));
            }
       return reservationDTOList;
    }

    @Override
    public ReservationRegisterDTO registerReservation(ReservationRegisterDTO reservationRegisterDTO) {

        Reservation newReservation = new Reservation();

        newReservation.setScheduledStartDate(reservationRegisterDTO.getScheduledStartDate());
        newReservation.setScheduledEndDate(reservationRegisterDTO.getScheduledEndDate());
        newReservation.setHectares(reservationRegisterDTO.getHectares());

        newReservation.setStatus("PENDING");
        newReservation.setRatePerHectare(150.0);
        newReservation.setTotalAmount(reservationRegisterDTO.getHectares() * 150.0);
        newReservation.setPayments(new ArrayList<>());

        reservationRepository.save(newReservation);

        return reservationRegisterDTO;
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).get();
    }

}
