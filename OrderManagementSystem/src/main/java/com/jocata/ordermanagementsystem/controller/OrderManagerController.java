package com.jocata.ordermanagementsystem.controller;

import com.jocata.ordermanagementsystem.form.OrderForm;
import com.jocata.ordermanagementsystem.service.OrderManagerService;
import com.jocata.ordermanagementsystem.service.imp.OrderManagerServiceImp;

public class OrderManagerController {
    private OrderManagerService service = new OrderManagerServiceImp();

    public void createOrder(OrderForm form) {
        String result = service.createOrder(form);
        System.out.println(result);
    }

    public void updateOrder(OrderForm form) {
        String result = service.updateOrder(form);
        System.out.println(result);
    }

    public void cancelOrder(int index) {
        String result = service.cancelOrder(index);
        System.out.println(result);
    }

    public OrderForm getOrder(int index) {
        OrderForm order = service.getOrder(index);
        if (order != null) {
            System.out.println("Order found: " + order);
        } else {
            System.out.println("Order not found at index: " + index);
        }
        return order;
    }

}
