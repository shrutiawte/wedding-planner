package com.example.wedding_planner_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wedding_planner_management.dao.ClientRepository;
import com.example.wedding_planner_management.dao.EventRepository;

import client.Client;
import client.Event;
import client.EventStatus;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ClientRepository clientRepository;

    // Add an event for a specific client
    public Event addEvent(Long clientId, Event event) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            event.setClient(client.get());
            return eventRepository.save(event);
        } else {
            throw new RuntimeException("Client not found");
        }
    }

    // Retrieve a specific event by id
    public Optional<Event> getEventById(Long eventId) {
        return eventRepository.findById(eventId);
    }

    // List all events, filtered by status
    public List<Event> getEventsByStatus(EventStatus status) {
        return eventRepository.findByStatus(status);
    }

    // List all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
