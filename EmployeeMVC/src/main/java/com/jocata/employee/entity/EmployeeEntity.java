package com.jocata.employee.entity;

import java.sql.Date;

public class EmployeeEntity {
    private String userName;
    private String designation;
    private Integer id;
    private Integer salary;
    private Date dateOfJoin;
    private Date dateOfBirth;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(String id) {
        try {
            this.id = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            this.id = null;
        }
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        try {
            this.salary = Integer.parseInt(salary);
        } catch (NumberFormatException e) {
            this.salary = null;
        }
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(String dateOfJoin) {
        try {
            this.dateOfJoin = Date.valueOf(dateOfJoin);
        } catch (IllegalArgumentException e) {
            this.dateOfJoin = null;
        }
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        try {
            this.dateOfBirth = Date.valueOf(dateOfBirth);
        } catch (IllegalArgumentException e) {
            this.dateOfBirth = null;
        }
    }
}
