package com.jocata.warranty_system.entity;

import com.jocata.warranty_system.util.CoverageType;
import com.jocata.warranty_system.util.WarrantyType;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "WarrantyPlans")
public class WarrantyPlans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Integer planId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "duration_months", nullable = false)
    private Integer durationMonths;

    @Column(name = "km_limit", nullable = false)
    private Integer kmLimit;

    @ManyToOne
    @JoinColumn(name = "warranty_type_id", nullable = false)
    private WarrantyTypes warrantyType;

    @ManyToOne
    @JoinColumn(name = "coverage_type_id", nullable = false)
    private CoverageTypes coverageType;

    @Column(name = "base_price", nullable = false)
    private BigDecimal basePrice;

    @Column(name = "surcharge_percent", nullable = false)
    private BigDecimal surchargePercent = BigDecimal.ZERO;

    // Getters and Setters
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(Integer durationMonths) {
        this.durationMonths = durationMonths;
    }

    public Integer getKmLimit() {
        return kmLimit;
    }

    public void setKmLimit(Integer kmLimit) {
        this.kmLimit = kmLimit;
    }

    public WarrantyTypes getWarrantyType() {
        return warrantyType;
    }
    public void setWarrantyType(WarrantyTypes warrantyType) {
        this.warrantyType = warrantyType;
    }

    public CoverageTypes getCoverageType() {
        return coverageType;
    }
    public void setCoverageType(CoverageTypes coverageType) {
        this.coverageType = coverageType;
    }


    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getSurchargePercent() {
        return surchargePercent;
    }

    public void setSurchargePercent(BigDecimal surchargePercent) {
        this.surchargePercent = surchargePercent;
    }
}
