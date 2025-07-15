package com.jocata.ordermanagementsystem.controller;

import com.jocata.ordermanagementsystem.service.PaymentService;
import com.jocata.ordermanagementsystem.service.imp.PaymentServiceImp;

public class PaymentController {
    private PaymentService service = new PaymentServiceImp();

    public String payment(Integer productId, Integer amountPaid) {
        return service.makePayment(productId, amountPaid);
    }
}
