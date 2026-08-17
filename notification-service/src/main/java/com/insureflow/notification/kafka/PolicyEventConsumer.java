package com.insureflow.notification.kafka;

import com.insureflow.notification.dto.PolicyEvent;
import com.insureflow.notification.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PolicyEventConsumer {
    private final EmailService emailService;

    public PolicyEventConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "policy-events", groupId = "notification-service")
    public void consume(PolicyEvent event) {
        emailService.sendPolicyEmail(
                event.email(),
                event.policyNo(),
                event.status()
        );
    }
}
