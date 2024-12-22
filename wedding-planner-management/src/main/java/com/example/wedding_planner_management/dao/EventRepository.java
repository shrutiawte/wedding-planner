package com.example.wedding_planner_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import client.Event;
import client.EventStatus;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    // Find events by status
    List<Event> findByStatus(EventStatus status);

    // Find events by client id
    List<Event> findByClientId(Long clientId);
}
