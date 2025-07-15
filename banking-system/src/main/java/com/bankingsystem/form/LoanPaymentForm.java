package com.bankingsystem.form;

public class LoanPaymentForm {

    private String paymentId;
    private String loanID;
    private String paymentDate;
    private String amountPaid;
    private String principalComponent;
    private String intrestComponent;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPrincipalComponent() {
        return principalComponent;
    }

    public void setPrincipalComponent(String principalComponent) {
        this.principalComponent = principalComponent;
    }

    public String getIntrestComponent() {
        return intrestComponent;
    }

    public void setIntrestComponent(String intrestComponent) {
        this.intrestComponent = intrestComponent;
    }
}
