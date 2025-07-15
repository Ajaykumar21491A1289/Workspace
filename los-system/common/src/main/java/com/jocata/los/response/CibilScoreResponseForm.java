package com.jocata.los.response;

import java.util.List;

public class CibilScoreResponseForm {

    private CibilScoreForm cibilScoreForm;
    private List<AccountForm> accountFormList;
    private List<EnquiryForm> enquiryForms;

    public CibilScoreForm getCibilScoreForm() {
        return cibilScoreForm;
    }

    public void setCibilScoreForm(CibilScoreForm cibilScoreForm) {
        this.cibilScoreForm = cibilScoreForm;
    }

    public List<AccountForm> getAccountFormList() {
        return accountFormList;
    }

    public void setAccountFormList(List<AccountForm> accountFormList) {
        this.accountFormList = accountFormList;
    }

    public List<EnquiryForm> getEnquiryForms() {
        return enquiryForms;
    }

    public void setEnquiryForms(List<EnquiryForm> enquiryForms) {
        this.enquiryForms = enquiryForms;
    }

}
