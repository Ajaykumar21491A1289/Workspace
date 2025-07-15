package com.jocata.ordermanagement.ordermanager.controller;

import com.jocata.ordermanagement.ordermanager.form.OrderForm;
import com.jocata.ordermanagement.ordermanager.service.OrderService;
import com.jocata.ordermanagement.ordermanager.service.impl.OrderServiceImpl;

import java.util.List;

public class OrderController {

    OrderService service = new OrderServiceImpl();

    public String addOrder(OrderForm form){

        if(form.getOrderId()!=null && !form.getOrderId().isEmpty() &&
       form.getCustomerId()!=null && !form.getCustomerId().isEmpty() &&
        form.getProductIds()!=null && !form.getProductIds().isEmpty() &&
        form.getStatus()!=null && !form.getStatus().isEmpty()){
           return service.addOrder(form);
        }
        return "Validation Not Satisfied";
    }

    public String updateOrder(OrderForm form){

        if(form.getOrderId()!=null && !form.getOrderId().isEmpty() &&
                form.getCustomerId()!=null && !form.getCustomerId().isEmpty() &&
                form.getProductIds()!=null && !form.getProductIds().isEmpty() &&
                form.getStatus()!=null && !form.getStatus().isEmpty()){
            return service.updateOrder(form);
        }
        return "Validation Not Satisfied";
    }

    public String cancleOrder(int orderId){
        return service.cancelOrder(orderId);

    }

    public List<OrderForm> getAllOrders(){
        return service.getAllOrders();

    }
    public OrderForm getOrder(Integer orderId){
        return service.getOrder(orderId);

    }
}
