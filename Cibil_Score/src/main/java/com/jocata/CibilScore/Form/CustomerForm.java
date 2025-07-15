package com.jocata.CibilScore.Form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jocata.CibilScore.entity.Addresses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class CustomerForm {

    @NotNull
    private String fullName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date dob;

    @NotBlank
    private String gender;

    @NotBlank
    private String pan;

    @NotBlank
    private String mobile;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String aadhar;

    @Valid
    private AddressForm address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public AddressForm getAddress() {
        return address;
    }

    public void setAddress(AddressForm address) {
        this.address = address;
    }
}
