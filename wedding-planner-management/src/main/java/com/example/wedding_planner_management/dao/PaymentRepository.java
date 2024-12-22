package com.example.wedding_planner_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import client.Payment;
import client.PaymentStatus;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
    // Query method to find payments by status
    List<Payment> findByStatus(PaymentStatus status);
    
    // Query method to find payments by client and status
    List<Payment> findByClientIdAndStatus(Long clientId, PaymentStatus status);
}

