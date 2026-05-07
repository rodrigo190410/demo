package com.example.demo.services;

import com.example.demo.entities.Authority;

public interface AuthorityService {

    public Authority findById(Long id);
    public Authority findByName(String name);
    public Authority add(Authority authority);

}
