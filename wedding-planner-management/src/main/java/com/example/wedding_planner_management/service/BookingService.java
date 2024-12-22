package com.example.wedding_planner_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wedding_planner_management.dao.BookingRepository;
import com.example.wedding_planner_management.dao.EventRepository;
import com.example.wedding_planner_management.dao.VendorRepository;

import client.Booking;
import client.Event;
import client.Vendor;
import client.VendorStatus;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private EventRepository eventRepository;

    // Book a vendor for a specific event, checking availability
    public Booking bookVendor(Long vendorId, Long eventId) {
        Optional<Vendor> vendor = vendorRepository.findById(vendorId);
        Optional<Event> event = eventRepository.findById(eventId);

        if (vendor.isPresent() && event.isPresent()) {
            if (vendor.get().getAvailabilityStatus() == VendorStatus.AVAILABLE) {
                Booking booking = new Booking();
                booking.setVendor(vendor.get());
                booking.setEvent(event.get());
                booking.setCancelled(false);
                return bookingRepository.save(booking);
            } else {
                throw new RuntimeException("Vendor is not available.");
            }
        } else {
            throw new RuntimeException("Vendor or Event not found.");
        }
    }

    // Cancel a vendor booking
    public Booking cancelBooking(Long bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            Booking updatedBooking = booking.get();
            updatedBooking.setCancelled(true);
            return bookingRepository.save(updatedBooking);
        } else {
            throw new RuntimeException("Booking not found.");
        }
    }
}
