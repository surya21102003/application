package com.demo.projectmanagementsystem.repo;

import com.demo.projectmanagementsystem.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepo extends JpaRepository<Subscription ,Long> {
    Subscription findByuserId(long userid);
}
