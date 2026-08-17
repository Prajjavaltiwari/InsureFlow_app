package com.insureflow.notification.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Component
public class ResendClient {
    private final RestClient restClient;
    private final String apiKey;
    private final String fromEmail;

    public ResendClient(
            @Value("${resend.api-key:}") String apiKey,
            @Value("${resend.from-email:}") String fromEmail) {
        this.apiKey = apiKey;
        this.fromEmail = fromEmail;
        this.restClient = RestClient.builder()
                .baseUrl("https://api.resend.com")
                .build();
    }

    public String sendEmail(String to, String subject, String html) {
        if (apiKey == null || apiKey.isBlank()) {
            return "Resend API key is not configured";
        }

        Map<String, Object> body = Map.of(
                "from", fromEmail,
                "to", new String[]{to},
                "subject", subject,
                "html", html
        );

        return restClient.post()
                .uri("/emails")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .body(String.class);
    }
}
