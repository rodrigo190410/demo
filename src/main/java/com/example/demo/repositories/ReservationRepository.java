package com.example.demo.repositories;

import com.example.demo.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    //QUERY METHOD
    List<Reservation> findByScheduledStartDateBetween(LocalDate startFilter, LocalDate endFilter);

    //JPQL
    @Query(value = "SELECT r FROM Reservation r WHERE r.customer.firstName=?1", nativeQuery = false)
    List<Reservation> findByCustomerName(String name);
}
