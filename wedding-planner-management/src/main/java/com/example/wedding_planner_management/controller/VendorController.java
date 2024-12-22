package com.example.wedding_planner_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.wedding_planner_management.service.VendorService;

import client.Vendor;
import client.VendorStatus;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    // POST endpoint to register a new vendor
    @PostMapping
    public ResponseEntity<Vendor> registerVendor(@RequestBody Vendor vendor) {
        Vendor savedVendor = vendorService.registerVendor(vendor);
        return new ResponseEntity<>(savedVendor, HttpStatus.CREATED);
    }

    // PUT endpoint to update the availability status of a vendor
    @PutMapping("/{id}/updateAvailability")
    public ResponseEntity<Vendor> updateAvailability(
            @PathVariable Long id, 
            @RequestParam VendorStatus status) {
        Vendor updatedVendor = vendorService.updateAvailability(id, status);
        return ResponseEntity.ok(updatedVendor);
    }
}
