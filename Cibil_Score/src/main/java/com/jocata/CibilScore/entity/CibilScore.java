package com.jocata.CibilScore.entity;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "cibil_scores")
public class CibilScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Integer scoreId;

    @OneToOne
    @JoinColumn(name="report_id")
    private CreditReports creditReports;

    @Column(name="score")
    private Integer score;

    @Column(name="score_date")
    private Date scoreDate;

    @Column(name="risk_grade")
    private String riskGrade;


    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public CreditReports getCreditReports() {
        return creditReports;
    }

    public void setCreditReports(CreditReports creditReports) {
        this.creditReports = creditReports;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(Date scoreDate) {
        this.scoreDate = scoreDate;
    }

    public String getRiskGrade() {
        return riskGrade;
    }

    public void setRiskGrade(String riskGrade) {
        this.riskGrade = riskGrade;
    }
}
