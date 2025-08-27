package com.example.backend.service.aiservice.agent;

/**
 * Represents a generic AI Agent.
 *
 * <p>All agents (e.g., Gemini, OpenAI, Anthropic, etc.) must implement this
 * interface so they can be created and managed uniformly through the {@link GenAiFactory}.</p>
 */
public interface Agent {
    /**
     * A simple test method to verify if the model is working.
     *
     * @return the model's response as a String
     */
    public String testModel();

    public String execute(String query);
}
