package com.jocata.los.entity;

import com.jocata.los.util.LoanStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="Loan_Applications")
public class LoanApplications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="application_id")
    private Integer applicationId;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customers customer;

    @Column(name="loan_amount")
    private BigDecimal loanAmount;

    @Column(name="loan_type")
    private String loanType;

    @Column(name="loan_tenure_months")
    private Integer loanTenureMonths;

    @Column(name="loan_purpose")
    private String loanPurpose;

    @Column(name="application_date",insertable = false, updatable = false)
    private Timestamp applicationDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @Column(name="approved_amount")
    private BigDecimal approvedAmount;

    @Column(name="is_active")
    private Boolean isActive;


    public Integer getId() {
        return applicationId;
    }

    public void setId(Integer id) {
        this.applicationId = id;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Timestamp getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Timestamp applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public Integer getLoanTenureMonths() {
        return loanTenureMonths;
    }

    public void setLoanTenureMonths(Integer loanTenureMonths) {
        this.loanTenureMonths = loanTenureMonths;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
