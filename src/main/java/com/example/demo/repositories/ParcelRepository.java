package com.example.demo.repositories;

import com.example.demo.entities.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {

}
