package com.example.demo.serviceimpl;

import com.example.demo.dto.PaymentUpdateDTO;
import com.example.demo.entities.Payment;
import com.example.demo.repositories.PaymentRepository;
import com.example.demo.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;



    @Override
    public Payment add(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id).get();
    }

    @Override
    public PaymentUpdateDTO update(PaymentUpdateDTO paymentUpdate) {

        Payment foundPayment = findById(paymentUpdate.getId());
        foundPayment.setPaymentStatus(paymentUpdate.getPaymentStatus());
        foundPayment.setPaymentMethod(paymentUpdate.getPaymentMethod());

        paymentRepository.save(foundPayment);
        return paymentUpdate;
    }


}
