package com.example.backend.service.aiservice.agentservice;

import org.springframework.stereotype.Component;

/**
 * Factory class responsible for creating instances of {@link AgentService}.
 *
 * <p>This factory provides a way to retrieve a specific service implementation
 * based on a given type. Currently supports {@code "pdf-analyser"}.</p>
 *
 * <p>Future implementations can add more services and extend the switch logic</p>
 */
@Component
public class AgentServiceFactory{
    private GeminiPdfAnalyser geminiPdfAnalyser;

    public AgentServiceFactory(GeminiPdfAnalyser geminiPdfAnalyser){
        this.geminiPdfAnalyser = geminiPdfAnalyser;
    }   

    /**
     * Returns an {@link AgentService} implementation based on the given type.
     *
     * @param type the type of service requested (e.g., "pdf-analyser")
     * @return the corresponding {@link AgentService}, or {@code null} if unsupported
     */
    public AgentService creaAgentService(String type){
        switch (type) {
            case "gemini-pdf-analyser":
                return geminiPdfAnalyser;
            default:
                return null;
        }
    }
}
