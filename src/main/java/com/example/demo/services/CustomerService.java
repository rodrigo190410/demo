package com.example.demo.services;

import com.example.demo.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer add(Customer customer);
    List<Customer> listAll();
    Customer findById(Long id);
}
