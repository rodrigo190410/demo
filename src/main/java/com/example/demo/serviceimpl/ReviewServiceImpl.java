package com.example.demo.serviceimpl;

import com.example.demo.dto.ReviewRegisterDTO;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.Review;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.services.ReservationService;
import com.example.demo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ReservationService reservationService;
    @Override
    public Review add(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public ReviewRegisterDTO register(ReviewRegisterDTO reviewRegister) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Customer customer = customerRepository.findByUser_username(username);

        Reservation reservation = reservationService.findById(reviewRegister.getReservationId());
        Review newReview = new Review(
                null,
                reviewRegister.getRating(),
                reviewRegister.getComment(),
                true, LocalDate.now(), customer,
                reservation
        );

        reviewRepository.save(newReview);
        return reviewRegister;
    }
}
