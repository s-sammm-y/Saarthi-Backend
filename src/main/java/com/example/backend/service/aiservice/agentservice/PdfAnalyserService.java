package com.example.backend.service.aiservice.agentservice;

import com.example.backend.service.aiservice.agent.Agent;

public interface PdfAnalyserService extends AgentService{
    String extractPdfContent(String filePath);
    Agent getAgent();
    void setAgent(Agent agent);
    String processPdfContent(String filePath);
}
