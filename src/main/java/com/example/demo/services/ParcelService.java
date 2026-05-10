package com.example.demo.services;

import com.example.demo.dto.ParcelDTO;
import com.example.demo.entities.Parcel;

public interface ParcelService {
    public Parcel add(Parcel parcel);
    public Parcel findById(Long id);
    public ParcelDTO register(ParcelDTO parcelDTO);
}
