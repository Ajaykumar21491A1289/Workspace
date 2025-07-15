package com.jocata.order.service;

import com.jocata.order.form.OrderForm;

import java.util.List;

public interface OrderService {
    public  String createOrder(OrderForm form);

    public String updateOrder(OrderForm form);

    public List<OrderForm> getAllOrders();

    public OrderForm getOrder(String orderId);

    public String cancelOrder(String OrderId);
}
