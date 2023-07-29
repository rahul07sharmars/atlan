package com.example.atlan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		logger.info("inside ClientRepository function of ClientServiceImp");
		List<ClientDetails> ls=clientRepository.findAll();
		String regex = "(0/91)?[7-9][0-9]{9}";
		System.out.println(ls.size()+"length of ls");
		for(ClientDetails clientDet:ls) {
			if(clientDet.getIncomePerAnnum()<clientDet.getSavingsPerAnnum())
				System.out.println("Saving per annum can't be greater than total income");
			if(!clientDet.getMobileNumber().matches(regex))
				System.out.println("Mobile number not valid");
		}
		return ls;
		
	}
	
	@Override
	public ClientDetails saveClient(ClientDetails client) {
		// TODO Auto-generated method stub
		logger.info("inside saveClient function of ClientServiceImp"+client.toString());
		String regex = "(0/91)?[7-9][0-9]{9}";
//		logger.info("")
		if(client.getIncomePerAnnum()<client.getSavingsPerAnnum()) {
			logger.warn("Saving per annum can't be greater than total income");
//			System.out.println("Saving per annum can't be greater than total income");
			return null;
		}
		if(!client.getMobileNumber().matches(regex)) {
			logger.warn("Mobile number not valid");
//			System.out.println("Mobile number not valid");
			return null;
		}
		ClientDetails clientResponse=clientRepository.save(client);
		logger.info("response from database"+clientResponse.toString());
//		System.out.print("clientResponse "+clientResponse.toString());
//		System.out.print("client in service "+client.toString());
		
		return clientResponse;
	}
	@Override
	public ClientDetails findByClientId(Integer clientId) {
		// TODO Auto-generated method stub
		logger.info("inside findByClientId function of ClientServiceImp" );
		return clientRepository.findByClientID(clientId);
	}
	
	
	

}
