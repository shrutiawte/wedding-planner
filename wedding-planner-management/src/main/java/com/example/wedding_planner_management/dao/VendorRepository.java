package com.example.wedding_planner_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import client.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
