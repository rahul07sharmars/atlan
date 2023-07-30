package com.example.atlan.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.atlan.Constants;
import com.example.atlan.controller.TranslateController;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

@Service
public class TranslateServiceImp implements TranslateService {


    
    private static final Logger logger = LoggerFactory.getLogger(TranslateServiceImp.class);
    @Override
	public String translateText(String sourceLanguage, String targetLanguage, String text) {
    	logger.info("inside translateText function of TranslateServiceImp");
    	logger.info("input Recived parms sourceLanguage: "+sourceLanguage +" targetLanguage: "+targetLanguage+" text: "+text);
    	
		Translate translate = TranslateOptions.newBuilder().setApiKey(Constants.API_KEY).build().getService();

        Translation translation = translate.translate(text, Translate.TranslateOption.sourceLanguage(sourceLanguage),
                Translate.TranslateOption.targetLanguage(targetLanguage));

        return translation.getTranslatedText();
		
	}

}
