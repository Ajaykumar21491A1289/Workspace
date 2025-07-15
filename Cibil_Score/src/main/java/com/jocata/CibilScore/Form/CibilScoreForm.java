package com.jocata.CibilScore.Form;

import jakarta.validation.constraints.*;

import java.sql.Date;

public class CibilScoreForm {

    @Min(300)
    @Max(900)
    private Integer score;


    @NotNull
    private Date scoreDate;


    @NotNull
    private String riskGrade;


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
