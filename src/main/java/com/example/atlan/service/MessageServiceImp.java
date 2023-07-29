package com.example.atlan.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.atlan.controller.MessageController;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class MessageServiceImp implements MessageService {

	public static final String ACCOUNT_SID = "AC7f5a9ac63791c4ce2cb9d9bcd1ca3645";
	public static final String AUTH_TOKEN = "9eb9c9749b30d0f12f93476677030667";
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Override
	public String sendMessage() {
		logger.info("inside sendMessage function fo MessageServiceImp");
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
				new com.twilio.type.PhoneNumber("+917976604882"),
				new com.twilio.type.PhoneNumber("+17623395876"),
				"Message from java Springboot")
				.create();
		logger.info("message send" + message.getTo());
		logger.info("message ID" + message.getSid());
		// System.out.println(message.getSid());
		return "Message Send";
	}

}
