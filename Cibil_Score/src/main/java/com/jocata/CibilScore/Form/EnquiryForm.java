package com.jocata.CibilScore.Form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

public class EnquiryForm {

    @NotNull
    private Date enquiryDate;

    @NotBlank
    private String memberName;

    @NotBlank
    private String enquiryPurpose;

    @NotNull
    private Double enquiryAmount;


    public Date getEnquiryDate() {
        return enquiryDate;
    }

    public void setEnquiryDate(Date enquiryDate) {
        this.enquiryDate = enquiryDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEnquiryPurpose() {
        return enquiryPurpose;
    }

    public void setEnquiryPurpose(String enquiryPurpose) {
        this.enquiryPurpose = enquiryPurpose;
    }

    public Double getEnquiryAmount() {
        return enquiryAmount;
    }

    public void setEnquiryAmount(Double enquiryAmount) {
        this.enquiryAmount = enquiryAmount;
    }
}
