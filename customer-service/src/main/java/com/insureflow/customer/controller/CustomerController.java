package com.insureflow.customer.controller;

import com.insureflow.customer.entity.Customer;
import com.insureflow.customer.entity.PolicySummary;
import com.insureflow.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/{customerId}/policies")
    public List<PolicySummary> getPolicy(@PathVariable Long customerId) {
        return customerService.getPolicy(customerId);
    }
}
