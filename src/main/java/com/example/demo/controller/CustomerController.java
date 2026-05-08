package com.example.demo.controller;

import com.example.demo.dto.CustomerQueryDTO;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/seedair/customers/") // http://localhost:8080/seedair
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/query1")//http://localhost:8080/seedair/customers/query1
    public List<CustomerQueryDTO> getCustomersNoReservation() {
        return customerService.getCustomersNoReservation();
    }


    @GetMapping("/query2/{cantidad}")//http://localhost:8080/seedair/customers/query2/{cantidad}
    public List<CustomerQueryDTO> getCustomersMoreThanParcels(@PathVariable Integer cantidad) {
        return customerService.getCustomersMoreThanParcels(cantidad);
    }


    @GetMapping("/query3") //http://localhost:8080/seedair/customers/query3
    public List<CustomerQueryDTO> getCustomersWithReservationNoReviews() {
        return customerService.getCustomersWithReservationNoReviews();
    }


    @GetMapping("/query4/{rating}")//http://localhost:8080/seedair/customers/query4/{rating}
    public List<CustomerQueryDTO> getCustomersHighRating(@PathVariable Double rating) {
        return customerService.getCustomersHighRating(rating);
    }
}
