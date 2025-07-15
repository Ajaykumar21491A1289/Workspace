package com.bankingsystem.entity;

import java.util.Date;

public class LoanCustomerEntity {

    private Integer customerId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date dob;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(String dob) {
        try {
            this.dob = java.sql.Date.valueOf(dob);
        } catch (IllegalArgumentException e) {
            this.dob = null;
        }
    }
}
