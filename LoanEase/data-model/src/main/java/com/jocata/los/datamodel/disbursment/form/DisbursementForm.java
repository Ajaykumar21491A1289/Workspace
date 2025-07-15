package com.jocata.los.datamodel.disbursment.form;

public class DisbursementForm {

    private Long loanId;
    private Double principal;
    private Integer months;

    // Response fields
    private Double annualInterestRate;
    private Double monthlyEmi;

    // Getters & Setters


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
