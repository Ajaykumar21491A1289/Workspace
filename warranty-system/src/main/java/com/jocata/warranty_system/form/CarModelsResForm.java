package com.jocata.warranty_system.form;

public class CarModelsResForm {

    private String id;
    private String make;
    private String modelName;
    private String year;
    private String basePrice;
    private String engineType;
    private String transmission;
    private String fuelType;
    private String seatingCapacity;
    private String warrantyDurationMonths;
    private String warrantyKmLimit;
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(String seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getWarrantyDurationMonths() {
        return warrantyDurationMonths;
    }

    public void setWarrantyDurationMonths(String warrantyDurationMonths) {
        this.warrantyDurationMonths = warrantyDurationMonths;
    }

    public String getWarrantyKmLimit() {
        return warrantyKmLimit;
    }

    public void setWarrantyKmLimit(String warrantyKmLimit) {
        this.warrantyKmLimit = warrantyKmLimit;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
