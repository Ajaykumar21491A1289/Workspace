package com.jocata.los.datamodel.disbursment.entity;

import jakarta.persistence.*;

@Entity
@Table(name="disbursement")
public class Disbursment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long loanId;

    private Double principal;
    private Integer months;
    private Double annualInterestRate;
    private Double monthlyEmi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(Double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Double getMonthlyEmi() {
        return monthlyEmi;
    }

    public void setMonthlyEmi(Double monthlyEmi) {
        this.monthlyEmi = monthlyEmi;
    }
}
