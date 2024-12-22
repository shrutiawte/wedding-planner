package com.example.wedding_planner_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.wedding_planner_management.service.PaymentService;

import client.Payment;
import client.PaymentStatus;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // POST endpoint to record a payment for a client
    @PostMapping
    public ResponseEntity<Payment> recordPayment(
            @RequestParam Long clientId, 
            @RequestParam double amount, 
            @RequestParam PaymentStatus status) {
        try {
            Payment payment = paymentService.recordPayment(clientId, amount, status);
            return new ResponseEntity<>(payment, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // GET endpoint to list all payments, with optional filter for status
    @GetMapping
    public ResponseEntity<List<Payment>> listPayments(
            @RequestParam(required = false) PaymentStatus status, 
            @RequestParam(required = false) Long clientId) {
        try {
            List<Payment> payments;
            if (clientId != null && status != null) {
                payments = paymentService.getPaymentsByClientAndStatus(clientId, status);
            } else if (status != null) {
                payments = paymentService.getPayments(status);
            } else {
                payments = paymentService.getPayments(null);  // Get all payments
            }
            return ResponseEntity.ok(payments);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}

