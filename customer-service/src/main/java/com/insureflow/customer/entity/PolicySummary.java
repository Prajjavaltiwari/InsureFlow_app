package com.insureflow.customer.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "policy_summary")
public class PolicySummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String insurerName;
    private Long customerId;
    private String policyNo;
    private String lob;
    private String status;
    private LocalDateTime updatedAt;

    public PolicySummary() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getInsurerName() { return insurerName; }
    public void setInsurerName(String insurerName) { this.insurerName = insurerName; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public String getPolicyNo() { return policyNo; }
    public void setPolicyNo(String policyNo) { this.policyNo = policyNo; }
    public String getLob() { return lob; }
    public void setLob(String lob) { this.lob = lob; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
