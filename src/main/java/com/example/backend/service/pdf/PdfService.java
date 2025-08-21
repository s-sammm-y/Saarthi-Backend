package com.example.backend.service.pdf;

import org.springframework.stereotype.Service;

import com.example.backend.service.aiservice.agent.Agent;
import com.example.backend.service.aiservice.agent.AgentFactory;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PdfService {
    
    private Agent agent;

    public PdfService(AgentFactory agentFactory){
        this.agent = agentFactory.createAgent("gemini");
    }

    public void testResponse(){
        System.out.println(agent.testModel());
    }
}
