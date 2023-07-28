package com.example.atlan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.atlan.entity.ClientDetails;
import com.example.atlan.repository.ClientRepository;

@Service
public class ClientServiceImp implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Override
	public List<ClientDetails> fetchAllClient() {
		// TODO Auto-generated method stub
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
	public ClientDetails findClientById(Integer id) {
		return clientRepository.findByClientID(id);
	}
	@Override
	public ClientDetails saveClient(ClientDetails client) {
		// TODO Auto-generated method stub
		String regex = "(0/91)?[7-9][0-9]{9}";
		if(client.getIncomePerAnnum()<client.getSavingsPerAnnum()) {
			System.out.println("Saving per annum can't be greater than total income");
			return null;
		}
		if(!client.getMobileNumber().matches(regex)) {
			System.out.println("Mobile number not valid");
			return null;
		}
		ClientDetails clientResponse=clientRepository.save(client);
		System.out.print("clientResponse "+clientResponse.toString());
		System.out.print("client in service "+client.toString());
		
		return clientResponse;
	}
	@Override
	public ClientDetails findByClientId(Integer clientId) {
		// TODO Auto-generated method stub
		return clientRepository.findByClientID(clientId);
	}
	
	
	

}
