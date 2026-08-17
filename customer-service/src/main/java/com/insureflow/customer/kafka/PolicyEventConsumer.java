package com.insureflow.customer.kafka;

import com.insureflow.customer.dto.PolicyEvent;
import com.insureflow.customer.entity.PolicySummary;
import com.insureflow.customer.service.CustomerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PolicyEventConsumer {
    private final CustomerService customerService;

    public PolicyEventConsumer(CustomerService customerService) {
        this.customerService = customerService;
    }

    @KafkaListener(topics = "policy-events", groupId = "customer")
    public void consume(PolicyEvent event) {
        PolicySummary summary = new PolicySummary();
        summary.setCustomerId(event.customerId());
        summary.setInsurerName(event.insurerName());
        summary.setPolicyNo(event.policyNo());
        summary.setLob(event.lob());
        summary.setStatus(event.status());
        summary.setUpdatedAt(LocalDateTime.now());

        customerService.savePolicySummary(summary);
    }
}
