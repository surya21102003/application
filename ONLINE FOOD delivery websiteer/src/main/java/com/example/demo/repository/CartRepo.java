package com.example.demo.repository;

import com.example.demo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart,Long> {
    public Cart findByCustomerId(Long userId);
}
