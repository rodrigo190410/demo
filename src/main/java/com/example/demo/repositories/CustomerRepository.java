package com.example.demo.repositories;

import com.example.demo.dto.CustomerQueryDTO;
import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT DISTINCT c.first_name as firstName, c.last_name as lastName, c.phone as phone " +
            "FROM customers c " +
            "INNER JOIN parcels p ON c.id = p.customer_id " +
            "LEFT JOIN reservations r ON p.id = r.parcel_id " +
            "WHERE r.id IS NULL", nativeQuery = true)
    List<CustomerQueryDTO> findCustomersWithParcelButNoReservation();


    @Query(value = "SELECT c.first_name as firstName, c.last_name as lastName, c.phone as phone " +
            "FROM customers c " +
            "INNER JOIN parcels p ON c.id = p.customer_id " +
            "GROUP BY c.id, c.first_name, c.last_name, c.phone " +
            "HAVING COUNT(p.id) > :cantidad", nativeQuery = true)
    List<CustomerQueryDTO> findCustomersWithMoreThanXParcels(@Param("cantidad") Integer cantidad);


    @Query(value = "SELECT DISTINCT c.first_name as firstName, c.last_name as lastName, c.phone as phone " +
            "FROM customers c " +
            "INNER JOIN parcels p ON c.id = p.customer_id " +
            "WHERE c.id NOT IN (SELECT customer_id FROM reviews)", nativeQuery = true)
    List<CustomerQueryDTO> findCustomersWithParcelAndNoReviews();


    @Query(value = "SELECT DISTINCT c.first_name as firstName, c.last_name as lastName, c.phone as phone " +
            "FROM customers c " +
            "INNER JOIN reviews r ON c.id = r.customer_id " +
            "WHERE r.is_visible = true AND r.rating > :ratingValue", nativeQuery = true)
    List<CustomerQueryDTO> findCustomersWithVisibleReviewAndRatingGreaterThan(@Param("ratingValue") Double ratingValue);

}
