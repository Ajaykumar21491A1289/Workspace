package com.jocata.ordermanagementsystem.controller;

import com.jocata.ordermanagementsystem.form.OrderForm;
import com.jocata.ordermanagementsystem.service.OrderHistoryService;
import com.jocata.ordermanagementsystem.service.imp.OrderHistoryServiceImp;

import java.util.List;

public class OrderHistoryController {

    private OrderHistoryService orderHistoryService = new OrderHistoryServiceImp();

    public void addCompletedOrder(OrderForm orderForm) {
        orderHistoryService.saveOrderToHistory(orderForm);
    }

    public List<OrderForm> getAllCompletedOrders() {
        return orderHistoryService.getCompletedOrders();
    }
}
