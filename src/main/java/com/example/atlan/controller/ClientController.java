package com.example.atlan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.atlan.entity.ClientDetails;
import com.example.atlan.service.ClientService;

@RestController()
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	
	@GetMapping("/client")
	public String home() {
		logger.info("inside home function of ClientController");
		return "Rahul Sharma";
	}
	
	@GetMapping("/all/client")
	public List<ClientDetails> fetchAllClient() {
		logger.info("inside fetchAllClient function of ClientController");
		return clientService.fetchAllClient();
	}
	
	@GetMapping("/client/findById/{id}")
	public ClientDetails findByClientId(@PathVariable("id") Integer clientId ) {
		logger.info("inside findByClientId function of ClientController with clientID"+clientId);
		return clientService.findByClientId(clientId);
	}
	
	@PostMapping("/add/client")
	public ClientDetails saveClient(@RequestBody ClientDetails client) {
		logger.info("inside findByClientId function of ClientController with clientID"+client.toString());
//		System.out.println("Client "+client.toString());
		return clientService.saveClient(client);
	}
}
