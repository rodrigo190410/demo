package com.example.demo.services;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entities.Customer;

import java.util.List;

public interface CustomerService {
    public Customer add(Customer customer);
    public List<Customer> listAll();
    public Customer findById(Long id);
    public CustomerDTO addDTO(CustomerDTO customerDTO);
}
