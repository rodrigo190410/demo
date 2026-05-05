package com.example.demo.services;

import com.example.demo.entities.User;

public interface UserService {
    User add(User user);
    User findById(Long id);
}
