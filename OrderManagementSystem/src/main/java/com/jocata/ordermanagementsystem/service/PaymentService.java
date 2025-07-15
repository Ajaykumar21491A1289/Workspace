package com.jocata.ordermanagementsystem.service;

public interface PaymentService {
    String makePayment(Integer productId, Integer amountPaid);
}
