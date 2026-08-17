package com.insureflow.customer.repository;

import com.insureflow.customer.entity.PolicySummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicySummaryRepository extends JpaRepository<PolicySummary, Long> {
}
