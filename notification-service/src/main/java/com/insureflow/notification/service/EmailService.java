package com.insureflow.notification.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final ResendClient resendClient;

    public EmailService(ResendClient resendClient) {
        this.resendClient = resendClient;
    }

    public String sendPolicyEmail(String email, String policyNo, String status) {
        String subject = "InsureFlow Policy Update";
        String html = "<p>Your policy <b>" + policyNo + "</b> status is <b>"
                + status + "</b>.</p>";

        return resendClient.sendEmail(email, subject, html);
    }
}
