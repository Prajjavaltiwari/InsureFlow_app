package com.insureflow.quote.dto;

import java.math.BigDecimal;

public record QuoteRequest(
        Long customerId,
        String insurerName,
        String lob,
        BigDecimal coverageLimit,
        String customerEmail
) {}
