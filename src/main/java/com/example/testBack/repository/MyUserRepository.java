package com.example.testBack.repository;

import com.example.testBack.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
    public boolean existsByEmail(String email);
    public boolean existsByUsername(String username);
}
