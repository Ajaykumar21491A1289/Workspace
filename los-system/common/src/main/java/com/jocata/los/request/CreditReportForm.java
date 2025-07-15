package com.jocata.los.request;

import com.jocata.los.response.AccountForm;

import java.util.List;

public class CreditReportForm {

    private String generatedOn;

    private CustomerForm customer;
    private List<AccountForm> accountsList;

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

    public List<AccountForm> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<AccountForm> accountsList) {
        this.accountsList = accountsList;
    }
}
