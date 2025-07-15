package com.jocata.los.form;

public class IncomeDetailsForm {

    private String customerId;
    private String monthlyIncome;
    private String employmentStatus;
    private String employerName;
    private String yearAtJob;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getYearAtJob() {
        return yearAtJob;
    }

    public void setYearAtJob(String yearAtJob) {
        this.yearAtJob = yearAtJob;
    }
}
