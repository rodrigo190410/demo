package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    //SQL NATIVE
    @Query(value = "SELECT * FROM users WHERE password = ?1", nativeQuery = true)
    public User findByPassword(String password);
}
