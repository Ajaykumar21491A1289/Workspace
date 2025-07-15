package com.jocata.ordermanagementsystem.dao;

import com.jocata.ordermanagementsystem.form.OrderForm;

public interface OrderManagerDao {
    String createOrder(OrderForm orderForm);
    String updateOrder(OrderForm orderForm);
    String cancelOrder(Integer orderId);
    OrderForm getOrder(Integer orderId);
}
