package com.insureflow.quote.kafka;

import com.insureflow.quote.dto.PolicyEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PolicyEventProducer {
    private static final String TOPIC = "policy-events";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PolicyEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(PolicyEvent event) {
        kafkaTemplate.send(TOPIC, String.valueOf(event.customerId()), event);
    }
}
