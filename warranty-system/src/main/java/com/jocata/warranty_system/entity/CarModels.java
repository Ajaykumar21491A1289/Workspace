package com.jocata.warranty_system.entity;

import com.jocata.warranty_system.util.EngineType;
import com.jocata.warranty_system.util.FuelType;
import com.jocata.warranty_system.util.Transmission;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "CarModels")
public class CarModels {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private int modelId;

    @Column(nullable = false, length = 100)
    private String make;


    @Column(name = "model_name", nullable = false, length = 100)
    private String modelName;

    @Column(nullable = false)
    private int year;

    @Column(name = "base_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal basePrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "engine_type", columnDefinition = "ENUM('Petrol', 'Diesel', 'Electric', 'Hybrid') default 'Petrol'")
    private EngineType engineType = EngineType.Petrol;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Manual', 'Automatic', 'SemiAutomatic') default 'Automatic'")
    private Transmission transmission = Transmission.Automatic;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", columnDefinition = "ENUM('Petrol', 'Diesel', 'Electric', 'Hybrid') default 'Petrol'")
    private FuelType fuelType = FuelType.Petrol;

    @Column(name = "seating_capacity")
    private Integer seatingCapacity;

    @Column(name = "warranty_duration_months")
    private Integer warrantyDurationMonths;

    @Column(name = "warranty_km_limit")
    private Integer warrantyKmLimit;

    @OneToMany(mappedBy = "modelId")
    private List<CarSaleRecords> carSales;


    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    // Getters and Setters

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Integer getWarrantyDurationMonths() {
        return warrantyDurationMonths;
    }

    public void setWarrantyDurationMonths(Integer warrantyDurationMonths) {
        this.warrantyDurationMonths = warrantyDurationMonths;
    }

    public Integer getWarrantyKmLimit() {
        return warrantyKmLimit;
    }

    public void setWarrantyKmLimit(Integer warrantyKmLimit) {
        this.warrantyKmLimit = warrantyKmLimit;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String toString() {
        return "CarModels{" +
                "modelId=" + modelId +
                ", make='" + make + '\'' +
                ", modelName='" + modelName + '\'' +
                ", year=" + year +
                ", basePrice=" + basePrice +
                ", engineType=" + engineType +
                ", transmission=" + transmission +
                ", fuelType=" + fuelType +
                ", seatingCapacity=" + seatingCapacity +
                ", warrantyDurationMonths=" + warrantyDurationMonths +
                ", warrantyKmLimit=" + warrantyKmLimit +
                ", createdAt=" + createdAt +
                '}';
    }
}
