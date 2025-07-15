package com.jocata.los.response;

import java.sql.Date;

public class EnquiryForm {

    private Date enquiryDate;

    private String memberName;

    private String enquiryPurpose;

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
