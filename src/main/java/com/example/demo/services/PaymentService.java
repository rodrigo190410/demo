package com.example.demo.services;

import com.example.demo.dto.PaymentUpdateDTO;
import com.example.demo.entities.Payment;

public interface PaymentService {
    public Payment add(Payment payment);
    public Payment findById(Long id);
    public PaymentUpdateDTO update(PaymentUpdateDTO paymentUpdate);
}
