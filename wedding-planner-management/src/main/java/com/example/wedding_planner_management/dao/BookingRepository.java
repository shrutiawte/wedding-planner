package com.example.wedding_planner_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import client.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
