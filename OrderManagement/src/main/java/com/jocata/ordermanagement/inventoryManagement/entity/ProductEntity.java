package com.jocata.ordermanagement.inventoryManagement.entity;

import java.io.Serializable;

public class ProductEntity implements Serializable {

    private int productId;
    private String productName;
    private double price;
    private int stockQuantity;
    private static final long serialVersionUID = 123;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
