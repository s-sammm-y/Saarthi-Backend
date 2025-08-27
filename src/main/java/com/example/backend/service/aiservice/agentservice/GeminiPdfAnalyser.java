package com.example.backend.service.aiservice.agentservice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

import com.example.backend.exception.ExtractContentException;
import com.example.backend.service.aiservice.agent.Agent;
import com.example.backend.service.aiservice.agent.GenAiFactory;


@Component
public class GeminiPdfAnalyser implements PdfAnalyserService{
    private Agent agent;
    public GeminiPdfAnalyser(GenAiFactory genAiFactory){
        this.agent = genAiFactory.createAgent("gemini");
    }

    public String getServiceName(){
        return "pdf-analyser with "+agent;
    }

    public Agent getAgent(){
        return this.agent;
    }

    public void setAgent(Agent agent){
        this.agent = agent;
    }

    public String extractPdfContent(String filePath) {

        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        } catch (IOException e) {
            throw new ExtractContentException(e.getMessage());
        }
    }

    public String processPdfContent(String filePath){
        String text = extractPdfContent(filePath);
        text += "\n this is my resume give me tips to improve it";
        return agent.execute(text);
    }


    
}
