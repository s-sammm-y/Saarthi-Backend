package com.example.backend.service.aiservice.agentservice;


/**
 * Represents a generic service that can be executed by an AI Agent.
 *
 * <p>Examples of services could be PDF analysis, text summarization,
 * data extraction, etc. Each service implementation should define
 * its own name and behavior.</p>
 */
public interface AgentService {

    /**
     * Returns the unique name of the service.
     *
     * @return the service name (e.g., "pdf-analyser")
     */
    public String getServiceName();   
}
