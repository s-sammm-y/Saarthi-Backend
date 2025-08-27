package com.example.backend.service.aiservice.agent;

import org.springframework.stereotype.Component;


/**
 * Factory class for creating AI Agent instances.
 *
 * <p>This class provides a central point to request specific agent
 * implementations based on a type string (e.g., "gemini").</p>
 *
 * <p>Currently supports only {@link GeminiAgent}, but can be extended
 * to support more agents in the future.</p>
 */
@Component
public class GenAiFactory{
    private GeminiAgent geminiAgent;
    
    public GenAiFactory(GeminiAgent geminiAgent){
        this.geminiAgent = geminiAgent;
    }
    
    /**
     * Creates an Agent instance based on the given type.
     *
     * @param type the type of agent (e.g., "gemini")
     * @return an {@link Agent} implementation, or {@code null} if the type is unsupported
     */
    public Agent createAgent(String type){
        switch (type.toLowerCase()) {
            case "gemini":
                return geminiAgent;
            default:
                return null;
        }
    }
}
