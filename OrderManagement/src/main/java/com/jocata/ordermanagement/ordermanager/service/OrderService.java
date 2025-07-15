package com.jocata.ordermanagement.ordermanager.service;

import com.jocata.ordermanagement.ordermanager.form.OrderForm;

import java.util.List;

public interface OrderService {
    String addOrder(OrderForm OrderForm);
    String updateOrder(OrderForm OrderForm);
    String cancelOrder(int orderId);
    List<OrderForm> getAllOrders();
    public OrderForm getOrder(Integer orderId);
}
