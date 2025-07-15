package com.jocata.ordermanagement.ordermanager.entity;
import java.io.Serializable;
import java.util.*;
public class OrderEntity  implements Serializable{

    private int orderId;
    private int customerId;
    private List<Integer> productIds;
    private String status;
    private static final long serialVersionUID = 124;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
