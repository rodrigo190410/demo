package com.example.demo.services;

import com.example.demo.dto.OperatorRegisterDTO;
import com.example.demo.entities.Operator;

public interface OperatorService {
    public Operator add(Operator operator);
    public Operator findById(Long id);
    public OperatorRegisterDTO register(OperatorRegisterDTO operatorRegister);
}
