package com.jocata.order.controller;

import com.jocata.order.form.OrderForm;
import com.jocata.order.service.OrderService;
import com.jocata.order.service.imp.OrderServiceImpl;

import java.util.List;

public class OrderController {

    public boolean validation(OrderForm form){
        if(form.getOrderId()!=null && !form.getOrderId().isEmpty() &&
                form.getItemName()!=null && !form.getItemName().isEmpty()&&

                form.getQuantity()!=null && !form.getQuantity().isEmpty() &&
                form.getOrderAddress()!=null && !form.getOrderAddress().isEmpty()&&
                form.getPhoneNumber()!=null && !form.getPhoneNumber().isEmpty() &&
                form.getCustomerName()!=null && !form.getCustomerName().isEmpty()){

                    return true;
        }
        return false;
    }


    public String createOrder(OrderForm form){
        if(validation(form)){
            OrderService service = new OrderServiceImpl();
            return service.createOrder(form);

        }
        return "Enter Proper Order Details";
    }

    public String updateOrder(OrderForm form){

        if(validation(form)){
            OrderService service = new OrderServiceImpl();
           return  service.updateOrder(form);
        }
        return "Order Id Not Found";
    }

    public void getAllOrders(){
        OrderService service = new OrderServiceImpl();
        List<OrderForm> forms = service.getAllOrders();
        for(OrderForm form: forms){
            System.out.println(form.getOrderId()+" "+form.getItemName()+" "+ form.getQuantity()+" "+form.getOrderAddress()+" "+form.getPhoneNumber()+" " +form.getCustomerName());
        }
    }

    public void getOrder(String orderid){

        OrderService service = new OrderServiceImpl();
        OrderForm form = service.getOrder(orderid);
        System.out.println(form.getOrderId()+" "+form.getItemName()+" "+ form.getQuantity()+" "+form.getOrderAddress()+" "+form.getPhoneNumber()+" " +form.getCustomerName());

    }

    public void cancelOrder(String orderId){

        OrderService service = new OrderServiceImpl();
        System.out.println(service.cancelOrder(orderId));

    }

    public static void closeController(){
       OrderServiceImpl.closeService();
    }
}
