package com.jocata.CibilScore.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="enquiries")
public class Enquiries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="enquire_id")
    private Integer enquireId;

    @ManyToOne
    @JoinColumn(name="report_id")
    private CreditReports creditReports;

    @Column(name="enquiry_date")
    private Date enquiryDate;

    @Column(name = "member_name")
    private String memberName;

    @Column(name="enquiry_purpose")
    private String enquiryPurpose;

    @Column(name="enquiry_amount")
    private BigDecimal enquiryAmount;


    public Integer getEnquireId() {
        return enquireId;
    }

    public void setEnquireId(Integer enquireId) {
        this.enquireId = enquireId;
    }

    public CreditReports getCreditReports() {
        return creditReports;
    }

    public void setCreditReports(CreditReports creditReports) {
        this.creditReports = creditReports;
    }

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

    public BigDecimal getEnquiryAmount() {
        return enquiryAmount;
    }

    public void setEnquiryAmount(BigDecimal enquiryAmount) {
        this.enquiryAmount = enquiryAmount;
    }
}
