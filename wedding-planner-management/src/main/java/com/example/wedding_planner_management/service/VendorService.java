package com.example.wedding_planner_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wedding_planner_management.dao.VendorRepository;

import client.Vendor;
import client.VendorStatus;

import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    // Register a new vendor
    public Vendor registerVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // Update the availability status of a vendor
    public Vendor updateAvailability(Long vendorId, VendorStatus status) {
        Optional<Vendor> vendor = vendorRepository.findById(vendorId);
        if (vendor.isPresent()) {
            Vendor updatedVendor = vendor.get();
            updatedVendor.setAvailabilityStatus(status);
            return vendorRepository.save(updatedVendor);
        } else {
            throw new RuntimeException("Vendor not found");
        }
    }
}
