package com.jocata.ordermanagementsystem.dao;

public interface PaymentDao {
    String processPayment(Integer productId, Integer amountPaid);
}
