package com.insureflow.quote.service;

import com.insureflow.quote.client.CustomerClient;
import com.insureflow.quote.dto.CustomerDto;
import com.insureflow.quote.dto.PolicyEvent;
import com.insureflow.quote.dto.QuoteRequest;
import com.insureflow.quote.entity.Quote;
import com.insureflow.quote.kafka.PolicyEventProducer;
import com.insureflow.quote.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;
    private final PremiumCalculator premiumCalculator;
    private final CustomerClient customerClient;
    private final PolicyEventProducer policyEventProducer;

    public QuoteService(QuoteRepository quoteRepository,
                        PremiumCalculator premiumCalculator,
                        CustomerClient customerClient,
                        PolicyEventProducer policyEventProducer) {
        this.quoteRepository = quoteRepository;
        this.premiumCalculator = premiumCalculator;
        this.customerClient = customerClient;
        this.policyEventProducer = policyEventProducer;
    }

    public Quote createQuote(QuoteRequest request) {
        CustomerDto customer = customerClient.getCustomer(request.customerId());

        Quote quote = new Quote();
        quote.setCustomerId(customer.id());
        quote.setInsurerName(customer.insurerName());
        quote.setLob(request.lob());
        quote.setCoverageLimit(request.coverageLimit());
        quote.setPremium(premiumCalculator.calculate(request.coverageLimit(), request.lob()));
        quote.setStatus("CREATED");
        quote.setCustomerEmail(customer.email());

        return quoteRepository.save(quote);
    }

    public Quote bindQuote(Long id) {
        Quote quote = getQuote(id);
        quote.setStatus("BOUND");
        quote.setPolicyNum("POL-" + quote.getId());
        Quote saved = quoteRepository.save(quote);

        policyEventProducer.publish(new PolicyEvent(
                saved.getCustomerId(),
                saved.getInsurerName(),
                saved.getCustomerEmail(),
                saved.getPolicyNum(),
                saved.getLob(),
                saved.getStatus()
        ));
        return saved;
    }

    public Quote updateQuote(Long id, QuoteRequest request) {
        Quote quote = getQuote(id);
        CustomerDto customer = customerClient.getCustomer(request.customerId());

        quote.setCustomerId(customer.id());
        quote.setInsurerName(customer.insurerName());
        quote.setLob(request.lob());
        quote.setCoverageLimit(request.coverageLimit());
        quote.setPremium(premiumCalculator.calculate(request.coverageLimit(), request.lob()));
        quote.setCustomerEmail(customer.email());

        return quoteRepository.save(quote);
    }

    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }

    public Quote getQuote(Long id) {
        return quoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quote not found: " + id));
    }

    public List<Quote> getQuotes() {
        return quoteRepository.findAll();
    }
}
