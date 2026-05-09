package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/seedair") // http://localhost:8080/seedair
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("users/register/customer") // http://localhost:8080/seedair/users/register/customer
    public ResponseEntity<CustomerDTO> register(@RequestBody CustomerDTO customer){
      CustomerDTO cust = customerService.addDTO(customer);
      return new ResponseEntity<>(cust, HttpStatus.CREATED);
    };
}
