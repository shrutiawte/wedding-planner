package com.example.wedding_planner_management.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import client.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByWeddingDateAndBudgetBetween(String weddingDate, Double minBudget, Double maxBudget);

	List<Client> findByWeddingDate(String weddingDate);

	List<Client> findByBudgetBetween(Double minBudget, Double maxBudget);}
