package com.example.atlan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
@RestController
public class TranslateController {
	private static final String API_KEY = "AIzaSyCxebiUD2XyTAXAJrOwK5oYNqXq-_7_PpU";

    public static String translateText(String sourceLanguage, String targetLanguage, String text) {
        Translate translate = TranslateOptions.newBuilder().setApiKey(API_KEY).build().getService();
        
        Translation translation = translate.translate(text, Translate.TranslateOption.sourceLanguage(sourceLanguage),
                Translate.TranslateOption.targetLanguage(targetLanguage));

        return translation.getTranslatedText();
    }
    
    
    @GetMapping("/language")
    public String translateLang() {
    	String sourceLanguage = "en"; // Source language code (e.g., "en" for English)
        String targetLanguage = "es"; // Target language code (e.g., "es" for Spanish)
        String textToTranslate = "Hello, how are you?"; // The text you want to translate

        String translatedText = translateText(sourceLanguage, targetLanguage, textToTranslate);
        System.out.println("Translated Text: " + translatedText);
        return translatedText;
    }
}
