package com.jocata.warranty_system.entity;

import com.jocata.warranty_system.util.WarrantyType;
import jakarta.persistence.*;

@Entity
@Table(name = "WarrantyTypes")
public class WarrantyTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="warranty_type_id")
    private Integer warrantyTypeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "name",columnDefinition = "ENUM('Basic', 'Extended')")
    private WarrantyType name;

    public Integer getWarrantyTypeId() {
        return warrantyTypeId;
    }

    public void setWarrantyTypeId(Integer warrantyTypeId) {
        this.warrantyTypeId = warrantyTypeId;
    }

    public WarrantyType getName() {
        return name;
    }

    public void setName(WarrantyType name) {
        this.name = name;
    }
}
