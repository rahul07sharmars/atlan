package com.example.atlan.controller;

import com.example.atlan.entity.MessageTemplate;
import com.example.atlan.service.DataServiceImp;
import com.example.atlan.service.MessageService;
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MessageController {

	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	@Autowired
	private MessageService messageService;

	@PostMapping("/message/custom")
	public String sendMessage(@RequestBody MessageTemplate messageTemplate) {
		logger.info(messageTemplate.toString());
		logger.info("inside send Message of MessageController");
		return messageService.sendMessage(messageTemplate);
	}
	@GetMapping("/message")
	public String sendMessage() {
		return messageService.sendMessage();
	}
}
