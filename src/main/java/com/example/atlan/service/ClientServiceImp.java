package com.example.atlan.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atlan.Global;
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
//	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
//	private static final String MOBILE_REGEX = "(0/91)?[7-9][0-9]{9}";
//	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	
	
	@Override
	public List<ClientDetails> fetchAllClient() {
		// TODO Auto-generated method stub
		logger.info("inside fetchAllClient function of ClientServiceImp");
		List<ClientDetails> clientList = clientRepository.findAll();
		
		logger.info("size of list: "+clientList.size());
		for (ClientDetails clientDetails : clientList) {
//			Matcher matcher=Global.pattern.matcher(clientDet.getClientEmail());
//			Matcher matcher = pattern.matcher(clientDet.getClientEmail());
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
//		// logger.info("")
//		if (client.getIncomePerAnnum() < client.getSavingsPerAnnum()) {
//			logger.warn("Saving per annum can't be greater than total income");
//			// System.out.println("Saving per annum can't be greater than total income");
//			return null;
//		}
//		if (!client.getMobileNumber().matches(regex)) {
//			logger.warn("Mobile number not valid");
//			// System.out.println("Mobile number not valid");
//			return null;
//		}
//		ClientDetails clientResponse = clientRepository.save(client);
//		logger.info("response from database" + clientResponse.toString());
//		// System.out.print("clientResponse "+clientResponse.toString());
//		// System.out.print("client in service "+client.toString());

		return null;
	}

	@Override
	public ClientDetails findByClientId(Integer clientId) {
		// TODO Auto-generated method stub
		logger.info("inside findByClientId function of ClientServiceImp");
		return clientRepository.findByClientID(clientId);
	}

}
