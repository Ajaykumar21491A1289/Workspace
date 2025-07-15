package com.jocata.inventory.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contactInfo;

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<StockMovement> stockMovement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<StockMovement> getStockMovement() {
        return stockMovement;
    }

    public void setStockMovement(List<StockMovement> stockMovement) {
        this.stockMovement = stockMovement;
    }
}
