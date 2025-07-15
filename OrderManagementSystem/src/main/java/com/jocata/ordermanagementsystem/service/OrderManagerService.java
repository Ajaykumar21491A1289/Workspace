package com.jocata.ordermanagementsystem.service;

import com.jocata.ordermanagementsystem.form.OrderForm;

import java.util.List;

public interface OrderManagerService {
    String createOrder(OrderForm orderForm);
    String updateOrder(OrderForm orderForm);
    String cancelOrder(Integer orderId);
    OrderForm getOrder(Integer orderId);
    // OrderManagerService.java


}
