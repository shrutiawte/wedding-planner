package com.example.wedding_planner_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.wedding_planner_management.dao.ClientRepository;
import com.example.wedding_planner_management.dao.PaymentRepository;

import client.Client;
import client.Payment;
import client.PaymentStatus;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ClientRepository clientRepository;

    // Record a payment for a client
    @Async
    public Payment recordPayment(Long clientId, double amount, PaymentStatus status) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            Payment payment = new Payment();
            payment.setClient(client.get());
            payment.setAmount(amount);
            payment.setStatus(status);
            payment.setPaymentDate(java.time.LocalDate.now());
            return paymentRepository.save(payment);
        } else {
            throw new RuntimeException("Client not found.");
        }
    }

    // List all payments with optional filters for status
    @Async
    @Transactional
    public List<Payment> getPayments(PaymentStatus status) {
        if (status != null) {
            return paymentRepository.findByStatus(status);
        }
        return paymentRepository.findAll();
    }

    // List all payments for a specific client with status filter
    public List<Payment> getPaymentsByClientAndStatus(Long clientId, PaymentStatus status) {
        return paymentRepository.findByClientIdAndStatus(clientId, status);
    }
}

