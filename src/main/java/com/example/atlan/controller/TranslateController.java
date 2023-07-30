package com.example.atlan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.atlan.service.TranslateService;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TranslateController {

    private static final Logger logger = LoggerFactory.getLogger(TranslateController.class);

    @Autowired
    private TranslateService translateService;

    @GetMapping("/translate/{lang1}{lang2}{text}")
    public String translateText(@PathVariable("lang1") String sourceLanguage,
            @PathVariable("lang2") String targetLanguage,
            @PathVariable("text") String text) {
        logger.info("inside translateText function of TranslateController");

        return translateService.translateText(sourceLanguage, targetLanguage, text);

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
