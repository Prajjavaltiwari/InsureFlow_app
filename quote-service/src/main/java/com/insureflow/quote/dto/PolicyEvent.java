package com.insureflow.quote.dto;

public record PolicyEvent(
        Long customerId,
        String insurerName,
        String email,
        String policyNo,
        String lob,
        String status
) {}
