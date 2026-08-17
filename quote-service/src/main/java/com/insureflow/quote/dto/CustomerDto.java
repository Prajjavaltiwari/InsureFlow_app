package com.insureflow.quote.dto;

public record CustomerDto(
        Long id,
        String insurerName,
        String email,
        String phone,
        String address
) {}
