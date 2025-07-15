package com.jocata.ordermanagement.payment.service;

import java.util.List;

public interface PaymentService {
    public String setPayment(Integer orderId,List<Integer> productId, double amountPaid);
    public String getPaymentStatus(int OrderId);
}
