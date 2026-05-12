package com.example.demo.services;

import com.example.demo.dto.ReviewRegisterDTO;
import com.example.demo.entities.Review;

public interface ReviewService {
    public Review add(Review review);
    public ReviewRegisterDTO register(ReviewRegisterDTO reviewRegister);
}
