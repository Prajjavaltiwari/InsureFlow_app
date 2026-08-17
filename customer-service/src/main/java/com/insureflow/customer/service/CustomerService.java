package com.insureflow.customer.service;

import com.insureflow.customer.entity.Customer;
import com.insureflow.customer.entity.PolicySummary;
import com.insureflow.customer.repository.CustomerRepository;
import com.insureflow.customer.repository.PolicySummaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PolicySummaryRepository policySummaryRepository;

    public CustomerService(CustomerRepository customerRepository,
                           PolicySummaryRepository policySummaryRepository) {
        this.customerRepository = customerRepository;
        this.policySummaryRepository = policySummaryRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + id));
    }

    public List<PolicySummary> getPolicy(Long customerId) {
        return policySummaryRepository.findAll()
                .stream()
                .filter(p -> customerId.equals(p.getCustomerId()))
                .toList();
    }

    public void savePolicySummary(PolicySummary policySummary) {
        policySummaryRepository.save(policySummary);
    }
}
