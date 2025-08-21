package com.example.backend.service.aiservice.agent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class GeminiAgent implements Agent {
    private Client client;
    private String model;
    private GenerateContentResponse response;
    private final Environment env;

    public GeminiAgent(Environment env){
        this.env=env;
        this.client = Client.builder().apiKey(env.getProperty("gemini.api.key")).build();;
        this.model = "gemini-2.5-flash";
    }

    public String testModel(){
        response = client.models.generateContent(model, "What is your name", null);
        return response.text();
    }
}
