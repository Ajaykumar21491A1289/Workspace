package com.jocata.warranty_system.entity;

import com.jocata.warranty_system.util.CarType;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "CarSaleRecords")
public class CarSaleRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_sale_id")
    private Integer carSaleId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customerId;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private CarModels modelId;

    @ManyToOne
    @JoinColumn(name = "car_type_id", nullable = false)
    private CarTypes carTypeId;

    @Column(name = "purchase_Date")
    private Date purchaseDate;


    public Integer getCarSaleId() {
        return carSaleId;
    }

    public void setCarSaleId(Integer carSaleId) {
        this.carSaleId = carSaleId;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    public CarModels getModelId() {
        return modelId;
    }

    public void setModelId(CarModels modelId) {
        this.modelId = modelId;
    }

    public CarTypes getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(CarTypes carTypeId) {
        this.carTypeId = carTypeId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
