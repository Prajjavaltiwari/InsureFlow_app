package com.insureflow.quote.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "quote")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String insurerName;
    private String lob;
    private BigDecimal coverageLimit;
    private BigDecimal premium;
    private String status;
    private String policyNum;
    private String customerEmail;
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Quote() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public String getInsurerName() { return insurerName; }
    public void setInsurerName(String insurerName) { this.insurerName = insurerName; }
    public String getLob() { return lob; }
    public void setLob(String lob) { this.lob = lob; }
    public BigDecimal getCoverageLimit() { return coverageLimit; }
    public void setCoverageLimit(BigDecimal coverageLimit) { this.coverageLimit = coverageLimit; }
    public BigDecimal getPremium() { return premium; }
    public void setPremium(BigDecimal premium) { this.premium = premium; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getPolicyNum() { return policyNum; }
    public void setPolicyNum(String policyNum) { this.policyNum = policyNum; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
