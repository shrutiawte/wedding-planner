package com.example.wedding_planner_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.wedding_planner_management.service.BookingService;

import client.Booking;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // POST endpoint to book a vendor for an event
    @PostMapping
    public ResponseEntity<Booking> bookVendor(@RequestParam Long vendorId, @RequestParam Long eventId) {
        try {
            Booking booking = bookingService.bookVendor(vendorId, eventId);
            return new ResponseEntity<>(booking, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // PUT endpoint to cancel a vendor booking
    @PutMapping("/{id}/cancel")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id) {
        try {
            Booking cancelledBooking = bookingService.cancelBooking(id);
            return ResponseEntity.ok(cancelledBooking);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
