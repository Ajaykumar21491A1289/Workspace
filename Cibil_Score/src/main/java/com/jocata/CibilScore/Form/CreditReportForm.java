package com.jocata.CibilScore.Form;

import com.jocata.CibilScore.entity.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreditReportForm {


    private Integer reportId;

    @NotNull
    private String generatedOn;

    @Valid
    private CustomerForm customer;

    @Valid
    private CibilScoreForm cibilScore;

    @Valid
    private List<AccountForm> accountsList;

    @Valid
    private List<EnquiryForm> enquiriesList;


    private List<String> remarksList;


    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(String generatedOn) {
        this.generatedOn = generatedOn;
    }

    public CustomerForm getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerForm customer) {
        this.customer = customer;
    }

    public CibilScoreForm getCibilScore() {
        return cibilScore;
    }

    public void setCibilScore(CibilScoreForm cibilScore) {
        this.cibilScore = cibilScore;
    }

    public List<AccountForm> getAccountsList() { return accountsList; }
    public void setAccountsList(List<AccountForm> accountsList) { this.accountsList = accountsList; }

    public List<EnquiryForm> getEnquiriesList() { return enquiriesList; }
    public void setEnquiriesList(List<EnquiryForm> enquiriesList) { this.enquiriesList = enquiriesList; }

    public List<String> getRemarksList() { return remarksList; }
    public void setRemarksList(List<String> remarksList) { this.remarksList = remarksList; }

}
