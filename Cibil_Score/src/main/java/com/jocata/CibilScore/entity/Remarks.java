package com.jocata.CibilScore.entity;


import jakarta.persistence.*;

@Entity
@Table(name="remarks")
public class Remarks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="remark_id")
    private Integer remarkId;

    @ManyToOne
    @JoinColumn(name="report_id")
    private CreditReports creditReports;

    @JoinColumn(name="description")
    private String description;


    public Integer getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(Integer remarkId) {
        this.remarkId = remarkId;
    }

    public CreditReports getCreditReports() {
        return creditReports;
    }

    public void setCreditReports(CreditReports creditReports) {
        this.creditReports = creditReports;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
