package com.example.atlan.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atlan.Constants;
import com.example.atlan.controller.ClientController;
import com.example.atlan.entity.ClientDetails;
import com.example.atlan.repository.ClientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp implements ClientService {

	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImp.class);
	@Autowired
	private ClientRepository clientRepository;
	@Override
	public List<ClientDetails> fetchAllClient() {
		// TODO Auto-generated method stub
		logger.info("inside fetchAllClient function of ClientServiceImp");
		List<ClientDetails> clientList = clientRepository.findAll();
		
		logger.info("size of list: "+clientList.size());
		for (ClientDetails clientDetails : clientList) {
			if(clientDetails.validateClient()!="valid")
				System.out.println(clientDetails.validateClient());
			
		}
		return clientList;

	}

	@Override
	public ClientDetails saveClient(ClientDetails client) {
		// TODO Auto-generated method stub
		logger.info("inside saveClient function of ClientServiceImp" + client.toString());
		if(client.validateClient()=="valid")
			return clientRepository.save(client);
		return null;
	}

	@Override
	public ClientDetails findByClientId(Integer clientId) {
		// TODO Auto-generated method stub
		logger.info("inside findByClientId function of ClientServiceImp");
		return clientRepository.findByClientID(clientId);
	}

}
