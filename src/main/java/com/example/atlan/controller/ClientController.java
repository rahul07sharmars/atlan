package com.example.atlan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.atlan.entity.ClientDetails;
import com.example.atlan.service.ClientService;

@RestController()
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/client")
	public String home() {
		return "Rahul Sharma";
	}
	
	@GetMapping("/all/client")
	public List<ClientDetails> fetchAllClient() {
		return clientService.fetchAllClient();
	}
	
	@GetMapping("/client/findById/{id}")
	public ClientDetails findByClientId(@PathVariable("id") Integer clientId ) {
		return clientService.findByClientId(clientId);
	}
	
	@PostMapping("/add/client")
	public ClientDetails saveClient(@RequestBody ClientDetails client) {
		System.out.println("Client "+client.toString());
		return clientService.saveClient(client);
	}
}
