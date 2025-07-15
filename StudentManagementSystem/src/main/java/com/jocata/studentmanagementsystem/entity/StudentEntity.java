package com.jocata.studentmanagementsystem.entity;

import java.sql.Date;

public class StudentEntity {

    private Integer studentId;
    private String studentName;
    private String email;
    private Long phone;
    private String address;
    private Date dob;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = Integer.parseInt(studentId);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = Long.valueOf(phone);
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
        this.dob =Date.valueOf(dob);
    }
}
