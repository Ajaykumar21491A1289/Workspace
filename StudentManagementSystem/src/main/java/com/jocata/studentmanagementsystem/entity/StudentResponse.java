package com.jocata.studentmanagementsystem.entity;

import java.sql.Date;

public class StudentResponse {
    private Integer StudentId;
    private String name;
    private String email;
    private Long phone;
    private String address;
    private Date dob;
    private String courseName;
    private String subjectName;
    private String grade;
    private String status;

    public Integer getStudentId() {
        return StudentId;
    }

    public void setStudentId(Integer studentId) {
        StudentId = studentId;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
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

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "StudentId=" + StudentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", courseName='" + courseName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", grade='" + grade + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
