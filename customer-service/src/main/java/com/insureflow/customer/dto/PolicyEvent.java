package com.insureflow.customer.dto;

public record PolicyEvent(
        Long customerId,
        String insurerName,
        String email,
        String policyNo,
        String lob,
        String status
) {}
