package com.example.demo.services;

import com.example.demo.entities.Parcel;

public interface ParcelService {
    Parcel add(Parcel parcel);
    Parcel findById(Long id);
}
