package com.jocata.los.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="Customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Integer customerId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private Long phoneNumber;


    @Column(name="dob")
    private Date dob;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;


    @Column(name="aadhar")
    private String aadhar;

    @Column(name="pan")
    private String pan;

    @OneToOne(mappedBy ="customer" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Address address;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<LoanApplications> loans;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private IncomeDetails incomeDetails;

    @OneToOne(mappedBy = "customer")
    private PanDetails panDetails;

    @OneToOne(mappedBy = "customer")
    private CibilScoreDetails cibilScoreDetails;

    @OneToOne(mappedBy = "customer")
    private AadharDetails aadharDetails;



    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<LoanApplications> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanApplications> loans) {
        this.loans = loans;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public IncomeDetails getIncomeDetails() {
        return incomeDetails;
    }

    public void setIncomeDetails(IncomeDetails incomeDetails) {
        this.incomeDetails = incomeDetails;
    }

    public PanDetails getPanDetails() {
        return panDetails;
    }

    public void setPanDetails(PanDetails panDetails) {
        this.panDetails = panDetails;
    }

    public CibilScoreDetails getCibilScoreDetails() {
        return cibilScoreDetails;
    }

    public void setCibilScoreDetails(CibilScoreDetails cibilScoreDetails) {
        this.cibilScoreDetails = cibilScoreDetails;
    }

    public AadharDetails getAadharDetails() {
        return aadharDetails;
    }

    public void setAadharDetails(AadharDetails aadharDetails) {
        this.aadharDetails = aadharDetails;
    }
}
