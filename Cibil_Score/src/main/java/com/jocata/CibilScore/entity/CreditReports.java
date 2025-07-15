package com.jocata.CibilScore.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="credit_reports")
public class CreditReports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="report_id")
    private Integer reportId;

    @Column(name="generated_on")
    private Date generatedOn;

    @OneToOne(mappedBy ="creditReports",cascade = CascadeType.ALL)
    private Customer customer;

    @OneToOne(mappedBy = "creditReports",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private CibilScore cibilScore;

    @OneToMany(mappedBy = "creditReports",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Accounts> accounts;

    @OneToMany(mappedBy = "creditReports",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Remarks> remarks;

    @OneToMany(mappedBy = "creditReports",cascade = CascadeType.ALL)
    private List<Enquiries> enquiries;


    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Date getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(Date generatedOn) {
        this.generatedOn = generatedOn;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CibilScore getCibilScore() {
        return cibilScore;
    }

    public void setCibilScore(CibilScore cibilScore) {
        this.cibilScore = cibilScore;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

    public List<Remarks> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<Remarks> remarks) {
        this.remarks = remarks;
    }

    public List<Enquiries> getEnquiries() {
        return enquiries;
    }

    public void setEnquiries(List<Enquiries> enquiries) {
        this.enquiries = enquiries;
    }
}
