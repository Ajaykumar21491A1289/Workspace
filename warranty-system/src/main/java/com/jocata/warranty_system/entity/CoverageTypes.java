package com.jocata.warranty_system.entity;

import com.jocata.warranty_system.util.CoverageType;
import jakarta.persistence.*;

@Entity
@Table(name = "CoverageTypes")
public class CoverageTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coverage_type_id")
    private Integer coverageTypeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private CoverageType name = CoverageType.Limited;

    public Integer getCoverageTypeId() {
        return coverageTypeId;
    }

    public void setCoverageTypeId(Integer coverageTypeId) {
        this.coverageTypeId = coverageTypeId;
    }

    public CoverageType getName() {
        return name;
    }

    public void setName(CoverageType name) {
        this.name = name;
    }
}
