package com.example.demo.serviceimpl;

import com.example.demo.entities.Parcel;
import com.example.demo.repositories.ParcelRepository;
import com.example.demo.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService{
    @Autowired
    ParcelRepository parcelRepository;

    @Override
    public Parcel add(Parcel parcel) {
        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel findById(Long id) {
        return parcelRepository.findById(id).get();
    }
}
