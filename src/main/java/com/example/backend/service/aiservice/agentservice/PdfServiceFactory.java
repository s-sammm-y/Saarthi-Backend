package com.example.backend.service.aiservice.agentservice;

import org.springframework.stereotype.Component;

@Component
public class PdfServiceFactory {
    private GeminiPdfAnalyser geminiPdfAnalyser;

    public PdfServiceFactory(GeminiPdfAnalyser geminiPdfAnalyser){
        this.geminiPdfAnalyser = geminiPdfAnalyser;
    }

    public PdfAnalyserService createAnalyserService(String type){
        switch (type) {
            case "gemini-pdf-analyser":
                return geminiPdfAnalyser;
        
            default:
                return null;
        }
    }
}
