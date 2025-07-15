package com.bankingsystem.entity;

import java.sql.Date;

public class LoanPaymentEntity {

    private Long paymentId;
    private Integer loanID;
    private Date paymentDate;
    private Float amountPaid;
    private Float principalComponent;
    private Float intrestComponent;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = Long.valueOf(paymentId);
    }

    public Integer getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {

        this.loanID = Integer.parseInt(loanID);
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = Date.valueOf(paymentDate);
    }

    public Float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = Float.valueOf(amountPaid);
    }

    public Float getPrincipalComponent() {
        return principalComponent;
    }

    public void setPrincipalComponent(String principalComponent) {
        this.principalComponent = Float.valueOf(principalComponent);
    }

    public Float getIntrestComponent() {
        return intrestComponent;
    }

    public void setIntrestComponent(String intrestComponent) {
        this.intrestComponent = Float.valueOf(intrestComponent);
    }
}
