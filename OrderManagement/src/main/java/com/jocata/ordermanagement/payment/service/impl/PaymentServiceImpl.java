package com.jocata.ordermanagement.payment.service.impl;

import com.jocata.ordermanagement.inventoryManagement.dao.InventoryDao;
import com.jocata.ordermanagement.inventoryManagement.dao.impl.InventoryDaoImpl;
import com.jocata.ordermanagement.ordermanager.Dao.OrderDao;
import com.jocata.ordermanagement.ordermanager.Dao.impl.OrderDaoImpl;
import com.jocata.ordermanagement.ordermanager.entity.OrderEntity;
import com.jocata.ordermanagement.payment.dao.PaymentDao;
import com.jocata.ordermanagement.payment.dao.impl.PaymentDaoImpl;
import com.jocata.ordermanagement.payment.entity.PaymentEntity;
import com.jocata.ordermanagement.payment.service.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    PaymentDao dao = new PaymentDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();
    InventoryDao inventoryDao = new InventoryDaoImpl();
    PaymentEntity paymentEntity = new PaymentEntity();

    public String setPayment(Integer orderId,List<Integer> productIds,double amountPaid){

        Double totalPrice=0.0;
        for (Integer productId : productIds) {
            Double price = inventoryDao.getProductDetails(productId).getPrice();
            totalPrice += price;
        }
        if(totalPrice==amountPaid){
            paymentEntity.setOrderId(orderId);
            paymentEntity.setPaymentStatus("PAID");
        }
        else {
            paymentEntity.setOrderId(orderId);
            paymentEntity.setPaymentStatus("UNPAID"); // or "PARTIALLY_PAID" based on your logic
        }
        return dao.setPayment(paymentEntity);
    }

    public String getPaymentStatus(int orderId){
        return dao.getPaymentStatus(orderId);

    }
}
