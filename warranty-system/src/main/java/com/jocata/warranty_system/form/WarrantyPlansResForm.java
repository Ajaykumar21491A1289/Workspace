package com.jocata.warranty_system.form;

public class WarrantyPlansResForm {

    private String planId;
    private String name;
    private String durationMonths;
    private String kmLimit;
    private String warrantyType;
    private String coverageType;
    private String basePrice;
    private String surchargePercent;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(String durationMonths) {
        this.durationMonths = durationMonths;
    }

    public String getKmLimit() {
        return kmLimit;
    }

    public void setKmLimit(String kmLimit) {
        this.kmLimit = kmLimit;
    }

    public String getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(String warrantyType) {
        this.warrantyType = warrantyType;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getSurchargePercent() {
        return surchargePercent;
    }

    public void setSurchargePercent(String surchargePercent) {
        this.surchargePercent = surchargePercent;
    }
}
