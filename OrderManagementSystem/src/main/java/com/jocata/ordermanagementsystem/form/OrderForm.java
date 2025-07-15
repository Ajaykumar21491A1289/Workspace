package com.jocata.ordermanagementsystem.form;

import java.io.Serializable;

public class OrderForm implements Serializable {
    private Integer productId;
    private Integer customerId;
    private String status;
    private Integer orderQuantity;
    private static final long serialVersionUID = -7518547348858483207L;


    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
