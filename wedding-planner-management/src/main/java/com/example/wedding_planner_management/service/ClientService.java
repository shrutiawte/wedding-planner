package com.example.wedding_planner_management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wedding_planner_management.dao.ClientRepository;

import client.Client;

@Service
public class ClientService {

	@Autowired
    private ClientRepository clientRepository;

    public Client registerClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public List<Client> getClients(String weddingDate, Double minBudget, Double maxBudget) {
        if (weddingDate != null && minBudget != null && maxBudget != null) {
            return clientRepository.findByWeddingDateAndBudgetBetween(weddingDate, minBudget, maxBudget);
        } else if (weddingDate != null) {
            return clientRepository.findByWeddingDate(weddingDate);
        } else if (minBudget != null && maxBudget != null) {
            return clientRepository.findByBudgetBetween(minBudget, maxBudget);
        } else {
            return clientRepository.findAll(); // Return all clients if no filter is provided
        }
    }
}
