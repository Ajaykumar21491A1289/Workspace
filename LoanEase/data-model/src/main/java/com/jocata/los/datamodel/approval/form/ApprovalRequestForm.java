package com.jocata.los.datamodel.approval.form;

public class ApprovalRequestForm {
    private Long loanId;
    private String status;
    private String remarks;

    // Getters and Setters
    public Long getLoanId() {
        return loanId;
    }
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
