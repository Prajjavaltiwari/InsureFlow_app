package com.insureflow.quote.client;

import com.insureflow.quote.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "${customer-service.url}")
public interface CustomerClient {

    @GetMapping("/customers/{id}")
    CustomerDto getCustomer(@PathVariable("id") Long id);
}
