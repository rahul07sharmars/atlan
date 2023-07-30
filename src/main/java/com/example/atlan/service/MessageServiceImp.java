package com.example.atlan.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.atlan.Constants;
import com.example.atlan.controller.MessageController;
import com.example.atlan.entity.MessageTemplate;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class MessageServiceImp implements MessageService {

	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Override
	public String sendMessage(MessageTemplate messageTemplate) {
		logger.info("inside sendMessage function fo MessageServiceImp");
		logger.info(messageTemplate.toString());
		Twilio.init(Constants.ACCOUNT_SID, Constants.AUTH_TOKEN);
		Message message = Message.creator(
				new com.twilio.type.PhoneNumber(messageTemplate.getMobileNumber()),
				new com.twilio.type.PhoneNumber("+17623395876"),
				messageTemplate.getMessgeBody())
				.create();
		logger.info("message send" + message.getTo());
		logger.info("message ID" + message.getSid());
		return "Message Send";
	}

	@Override
	public String sendMessage() {
		logger.info("inside sendMessage function fo MessageServiceImp");
		
		Twilio.init(Constants.ACCOUNT_SID, Constants.AUTH_TOKEN);
		Message message = Message.creator(
				new com.twilio.type.PhoneNumber("+917976604882"),
				new com.twilio.type.PhoneNumber("+17623395876"),
				"Messsage from Java Springboot")
				.create();
		logger.info("message send" + message.getTo());
		logger.info("message ID" + message.getSid());
		return "Message Send";
		
	}

}
