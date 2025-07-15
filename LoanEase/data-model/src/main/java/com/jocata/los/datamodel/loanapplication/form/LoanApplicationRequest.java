package com.jocata.los.datamodel.loanapplication.form;

public class LoanApplicationRequest {

    private String userId;
    private String amount;
    private String termInMonths;
    private String purpose;
    private String status;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTermInMonths() {
        return termInMonths;
    }

    public void setTermInMonths(String termInMonths) {
        this.termInMonths = termInMonths;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
