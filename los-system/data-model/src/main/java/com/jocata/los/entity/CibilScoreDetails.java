package com.jocata.los.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="Cibil_Details")
public class CibilScoreDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @Column(name="cibil_score")
    private Integer cibilScore;

    @Column(name="last_update" , insertable = false,updatable = false)
    private Date lastUpdated;

    @Column(name="credit_status")
    private String creditStatus;

    @Column(name="no_of_enquiry")
    private Integer noOfEnquiry;

    @Column(name="no_of_active_accounts")
    private Integer noOfActiveAccounts;

    @Column(name="loan_outstanding")
    private String loanOutstanding;

    @Column(name="emis_total")
    private BigDecimal emisTotal;

    @Column(name="time_stamp",insertable = false,updatable = false)
    private Timestamp timeStamp;


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

    public Integer getCibilScore() {
        return cibilScore;
    }

    public void setCibilScore(Integer cibilScore) {
        this.cibilScore = cibilScore;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }

    public Integer getNoOfEnquiry() {
        return noOfEnquiry;
    }

    public void setNoOfEnquiry(Integer noOfEnquiry) {
        this.noOfEnquiry = noOfEnquiry;
    }

    public Integer getNoOfActiveAccounts() {
        return noOfActiveAccounts;
    }

    public void setNoOfActiveAccounts(Integer noOfActiveAccounts) {
        this.noOfActiveAccounts = noOfActiveAccounts;
    }

    public String getLoanOutstanding() {
        return loanOutstanding;
    }

    public void setLoanOutstanding(String loanOutstanding) {
        this.loanOutstanding = loanOutstanding;
    }

    public BigDecimal getEmisTotal() {
        return emisTotal;
    }

    public void setEmisTotal(BigDecimal overDue) {
        this.emisTotal = overDue;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }
}
