package com.bankingsystem.entity;

import java.util.Date;

public class LoanResponseEntity {

    private Integer loanId;
    private String customerName;
    private String loanType;
    private String branchType;
    private String statusName;
    private Float principalAmount;
    private Float intrestRate;
    private Integer termMonths;
    private Date startDate;
    private Date endDate;

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Float getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Float principalAmount) {
        this.principalAmount = principalAmount;
    }

    public Float getIntrestRate() {
        return intrestRate;
    }

    public void setIntrestRate(Float intrestRate) {
        this.intrestRate = intrestRate;
    }

    public Integer getTermMonths() {
        return termMonths;
    }

    public void setTermMonths(Integer termMonths) {
        this.termMonths = termMonths;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
