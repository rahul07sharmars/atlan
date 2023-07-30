package com.example.atlan.service;

import com.example.atlan.entity.MessageTemplate;

public interface MessageService {

	String sendMessage(MessageTemplate messageTemplate);

	String sendMessage();

}
