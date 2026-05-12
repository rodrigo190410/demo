package com.example.demo.serviceimpl;

import com.example.demo.dto.OperatorRegisterDTO;
import com.example.demo.entities.Operator;
import com.example.demo.repositories.OperatorRepository;
import com.example.demo.services.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorServiceImpl implements OperatorService {
    @Autowired
    OperatorRepository operatorRepository;
    @Override
    public Operator add(Operator operator) {
        return operatorRepository.save(operator);
    }

    @Override
    public Operator findById(Long id) {
        return operatorRepository.findById(id).get();
    }

    @Override
    public OperatorRegisterDTO register(OperatorRegisterDTO operatorRegister) {

        Operator newOperator =  new Operator(
                null, operatorRegister.getLicenseCode(),
                operatorRegister.getCertificationLevel(),
                operatorRegister.getExperienceYears(), true,
                null
        );
        operatorRepository.save(newOperator);
        return operatorRegister;
    }
}
