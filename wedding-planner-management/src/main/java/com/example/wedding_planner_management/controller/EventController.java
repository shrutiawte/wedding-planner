package com.example.wedding_planner_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.wedding_planner_management.service.EventService;

import client.Event;
import client.EventStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // POST endpoint to add an event for a specific client
    @PostMapping("/{clientId}")
    public ResponseEntity<Event> addEvent(@PathVariable Long clientId, @RequestBody Event event) {
        Event savedEvent = eventService.addEvent(clientId, event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    // GET endpoint to retrieve details of a specific event
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET endpoint to list all events, with optional filtering by status
    @GetMapping
    public List<Event> getEvents(
            @RequestParam(required = false) EventStatus status) {
        if (status != null) {
            return eventService.getEventsByStatus(status);
        } else {
            return eventService.getAllEvents();  // Return all events if no filter is provided
        }
    }
}
