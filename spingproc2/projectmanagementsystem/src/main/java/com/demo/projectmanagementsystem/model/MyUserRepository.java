package com.demo.projectmanagementsystem.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUserRepository extends JpaRepository<Myuser, Long> {

    Optional<Myuser> findByUsername(String username);
    Myuser findByEmail(String email);
}
