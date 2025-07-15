package com.jocata.order.entity;

import java.io.Serializable;

public class OrderEntity implements Serializable {

    Integer  orderId;
    String  itemName;
    Integer quantity;
    String  orderAddress;
    String    phoneNumber;
    String  customerName;
    private static final long serialVersionUID = 1L;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        try {
            this.quantity = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            this.quantity = null;
        }
    }

    public void setEntityQuantity(Integer quantity) {
        this.quantity=quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        try {
            this.orderId = Integer.parseInt(orderId);
        } catch (NumberFormatException e) {
            this.orderId = null;
        }
    }
    public void setEntityOrderId(Integer orderId) {
       this.orderId=orderId;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId=" + orderId +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", orderAddress='" + orderAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
