package com.insureflow.quote.controller;

import com.insureflow.quote.dto.QuoteRequest;
import com.insureflow.quote.entity.Quote;
import com.insureflow.quote.service.QuoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public Quote createQuote(@RequestBody QuoteRequest request) {
        return quoteService.createQuote(request);
    }

    @PutMapping("/{id}/bind")
    public Quote bindQuote(@PathVariable Long id) {
        return quoteService.bindQuote(id);
    }

    @PutMapping("/{id}")
    public Quote updateQuote(@PathVariable Long id,
                             @RequestBody QuoteRequest request) {
        return quoteService.updateQuote(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
    }

    @GetMapping("/{id}")
    public Quote getQuote(@PathVariable Long id) {
        return quoteService.getQuote(id);
    }

    @GetMapping
    public List<Quote> getQuotes() {
        return quoteService.getQuotes();
    }
}
