package com.jocata.los.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="Income_Details")
public class IncomeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @Column(name = "monthly_income")
    private BigDecimal monthlyIncome;

    @Column(name="employment_status")
    private String employmentStatus;

    @Column(name="employer_name")
    private String employerName;

    @Column(name="years_at_job")
    private Integer yearsAtJob;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
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

    public Integer getYearsAtJob() {
        return yearsAtJob;
    }

    public void setYearsAtJob(Integer yearsAtJob) {
        this.yearsAtJob = yearsAtJob;
    }
}
