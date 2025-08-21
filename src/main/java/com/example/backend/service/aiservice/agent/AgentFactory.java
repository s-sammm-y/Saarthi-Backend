package com.example.backend.service.aiservice.agent;

import org.springframework.stereotype.Component;

@Component
public class AgentFactory {
    private GeminiAgent geminiAgent;
    
    public AgentFactory(GeminiAgent geminiAgent){
        this.geminiAgent = geminiAgent;
    }
    
    public Agent createAgent(String type){
        switch (type.toLowerCase()) {
            case "gemini":
                return geminiAgent;
            default:
                return null;
        }
    }
}
