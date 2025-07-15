package com.bankingsystem.entity;

public class LoanTypeEntity {

    private Integer loanTypeId;
    private String loanType;
    private Float intrestRate;

    public Integer getLoanTypeId() {
        return loanTypeId;
    }

    public void setLoanTypeId(Integer loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Float getIntrestRate() {
        return intrestRate;
    }

    public void setIntrestRate(Float intrestRate) {
        this.intrestRate = intrestRate;
    }
}
