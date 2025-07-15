package com.jocata.ordermanagement.payment.entity;

import java.io.Serializable;

public class PaymentEntity  implements Serializable {
    private int orderId;
    private String paymentStatus;
    private static final long serialVersionUID = 125;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
