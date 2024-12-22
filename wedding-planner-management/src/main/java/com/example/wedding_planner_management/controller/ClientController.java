package com.example.wedding_planner_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.wedding_planner_management.service.ClientService;

import client.Client;

@RestController
@RequestMapping("/clients")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @GetMapping("/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
    
    
    @GetMapping("/{id}") //Retrieve details of a specific client.
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.getClientById(id);
        return client.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/clients")//: List all clients, with options to filter by wedding date or budget range.
    public List<Client> getClients(
            @RequestParam(required = false) String weddingDate,
            @RequestParam(required = false) Double minBudget,
            @RequestParam(required = false) Double maxBudget) {
        
        return clientService.getClients(weddingDate, minBudget, maxBudget);
    }
    
    @PostMapping("/register-clients") //Register a new client and their wedding details.
    public ResponseEntity<Client> registerClient(@RequestBody Client client) {
        
        Client savedClient = clientService.registerClient(client);

        
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }
    
}
