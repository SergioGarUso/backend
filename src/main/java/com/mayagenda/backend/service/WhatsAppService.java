package com.mayagenda.backend.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WhatsAppService {

    private final String apiUrl = "https://graph.facebook.com/v17.0/YOUR_PHONE_NUMBER_ID/messages";
    private final String token = "YOUR_ACCESS_TOKEN";

    public void enviarMensaje(String telefono, String mensaje) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = Map.of(
            "messaging_product", "whatsapp",
            "to", telefono,
            "type", "text",
            "text", Map.of("body", mensaje)
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        restTemplate.postForEntity(apiUrl, request, String.class);
    }
}
