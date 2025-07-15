package com.jocata.CibilScore.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;


@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="customer_id")
    private Integer customerId;

    @OneToOne
    @JoinColumn(name="report_id")
    private CreditReports creditReports;

    @Column(name="full_name")
    private String fullName;

    @Column(name="dob")
    private Date dob;

    @Column(name="gender")
    private String gender;

    @Column(name="pan")
    private String pan;

    @Column(name="mobile")
    private Long mobile;

    @Column(name="email")
    private String email;

    @Column(name="aadhar")
    private Long aadhar;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    private Addresses addresses;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public CreditReports getCreditReports() {
        return creditReports;
    }

    public void setCreditReports(CreditReports creditReports) {
        this.creditReports = creditReports;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAadhar() {
        return aadhar;
    }

    public void setAadhar(Long aadhar) {
        this.aadhar = aadhar;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }
}
