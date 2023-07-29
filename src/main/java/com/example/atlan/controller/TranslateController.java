package com.example.atlan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TranslateController {

    private static final Logger logger = LoggerFactory.getLogger(TranslateController.class);

    private static final String API_KEY = "AIzaSyCxebiUD2XyTAXAJrOwK5oYNqXq-_7_PpU";

    @GetMapping("/translate/{lang1}{lang2}{text}")
    // @PathVariable("id") Integer clientId
    // String sourceLanguage, String targetLanguage, String text
    public static String translateText(@PathVariable("lang1") String sourceLanguage,
            @PathVariable("lang2") String targetLanguage,
            @PathVariable("text") String text) {
        logger.info("inside translateText function of TranslateController");
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
