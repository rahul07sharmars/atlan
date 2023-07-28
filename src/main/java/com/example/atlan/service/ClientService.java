package com.example.atlan.service;

import java.util.List;

import com.example.atlan.entity.ClientDetails;

public interface ClientService {

	List<ClientDetails> fetchAllClient();

	ClientDetails saveClient(ClientDetails client);
	ClientDetails findByClientId(Integer clientId);
	
	

}
