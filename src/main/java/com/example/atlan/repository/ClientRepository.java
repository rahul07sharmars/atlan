package com.example.atlan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.atlan.entity.ClientDetails;

@Repository
public interface ClientRepository extends JpaRepository<ClientDetails, Integer> {

	// @Query("")
	public List<ClientDetails> findAll();

	public ClientDetails findByClientID(Integer id);
}
