package com.example.atlan.controller;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MessageController {

	public static final String ACCOUNT_SID = "AC7f5a9ac63791c4ce2cb9d9bcd1ca3645";
	  public static final String AUTH_TOKEN = "9eb9c9749b30d0f12f93476677030667";
	  
	 @GetMapping("/message")
	 public void sendMessage() {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		    Message message = Message.creator(
		      new com.twilio.type.PhoneNumber("+917976604882"),
		      new com.twilio.type.PhoneNumber("+17623395876"),
		      "Your message")
		    .create();

		    System.out.println(message.getSid());
	 }
}
