package com.jocata.los.datamodel.loanapplication.form;

public class LoanApplicationResponse {

    private String message;
    private Double salary;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
