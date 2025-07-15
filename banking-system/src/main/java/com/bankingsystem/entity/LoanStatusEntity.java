package com.bankingsystem.entity;

public class LoanStatusEntity {

    private String statusName;
    private Integer statsId;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getStatusId() {
        return statsId;
    }

    public void setStatsId(Integer statsId) {
        this.statsId = statsId;
    }
}
