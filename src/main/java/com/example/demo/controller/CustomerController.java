package com.example.demo.controller;

import com.example.demo.dto.CustomerQueryDTO;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/seedair/customers/") // http://localhost:8080/seedair
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    // 1.GET: http://localhost:8080/customers/query1
    @GetMapping("/query1")
    public List<CustomerQueryDTO> getCustomersNoReservation() {
        return customerRepository.findCustomersWithParcelButNoReservation();
    }

    // 2.GET: http://localhost:8080/customers/query2/0
    @GetMapping("/query2/{cantidad}")
    public List<CustomerQueryDTO> getCustomersMoreThanParcels(@PathVariable Integer cantidad) {
        return customerRepository.findCustomersWithMoreThanXParcels(cantidad);
    }

    // 3.GET: http://localhost:8080/customers/query3/
    @GetMapping("/query3")
    public List<CustomerQueryDTO> getCustomersNoReviews() {
        return customerRepository.findCustomersWithParcelAndNoReviews();
    }

    // 4.GET: http://localhost:8080/customers/query4/4.5
    @GetMapping("/query4/{rating}")
    public List<CustomerQueryDTO> getCustomersHighRating(@PathVariable Double rating) {
        return customerRepository.findCustomersWithVisibleReviewAndRatingGreaterThan(rating);
    }
}
