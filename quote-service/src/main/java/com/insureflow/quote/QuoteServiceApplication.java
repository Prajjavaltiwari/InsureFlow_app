package com.insureflow.quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class QuoteServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuoteServiceApplication.class, args);
    }
}
