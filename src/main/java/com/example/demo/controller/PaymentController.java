package com.example.demo.controller;

import com.example.demo.dto.PaymentUpdateDTO;
import com.example.demo.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/seedair") // http://localhost:8080/seedair
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PutMapping("/payments/set")  // http://localhost:8080/seedair/payments/set
    public ResponseEntity<PaymentUpdateDTO> update(@RequestBody PaymentUpdateDTO paymentUpdate){
            PaymentUpdateDTO updatedPayment = paymentService.update(paymentUpdate);
            return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }
}
