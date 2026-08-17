package com.insureflow.quote.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PremiumCalculator {

    public BigDecimal calculate(BigDecimal coverageLimit, String lob) {
        if (coverageLimit == null) {
            return BigDecimal.ZERO;
        }

        // The notes only specify that a PremiumCalculator exists.
        // Keep the calculation simple and deterministic.
        return switch (lob == null ? "" : lob.toUpperCase()) {
            case "CF" -> coverageLimit.multiply(new BigDecimal("4.020"));
            case "GL" -> coverageLimit.multiply(new BigDecimal("2.015"));
            case "PLCAPP" -> coverageLimit.multiply(new BigDecimal("3.025"));
            default -> coverageLimit.multiply(new BigDecimal("1.020"));
        };
    }
}
