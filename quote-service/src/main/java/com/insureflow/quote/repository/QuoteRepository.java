package com.insureflow.quote.repository;

import com.insureflow.quote.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
