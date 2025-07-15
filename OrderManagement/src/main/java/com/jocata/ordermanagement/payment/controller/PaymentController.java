package com.jocata.ordermanagement.payment.controller;

import com.jocata.ordermanagement.payment.service.PaymentService;
import com.jocata.ordermanagement.payment.service.impl.PaymentServiceImpl;

import java.util.List;

public class PaymentController {

    PaymentService service = new PaymentServiceImpl();

    public String setPayment(Integer orderId,List<Integer> productId, double amountPaid){
        return service.setPayment(orderId,productId,amountPaid);
    }

    public String getPaymentStatus(int orderId){
        return service.getPaymentStatus(orderId);
    }
}
