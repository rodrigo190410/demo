package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;

public interface UserService {
    public User add(User user);
    public User findById(Long id);
    public User findByUsername(String username);
    public UserDTO addDTO(UserDTO userDTO);
}
