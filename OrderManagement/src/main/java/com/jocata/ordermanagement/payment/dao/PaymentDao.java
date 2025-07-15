package com.jocata.ordermanagement.payment.dao;

import com.jocata.ordermanagement.payment.entity.PaymentEntity;

public interface PaymentDao {

    public String setPayment(PaymentEntity entity);
    public String getPaymentStatus(int OrderId);
}
