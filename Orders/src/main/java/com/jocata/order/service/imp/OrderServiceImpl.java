package com.jocata.order.service.imp;

import com.jocata.order.dao.OrderDao;
import com.jocata.order.dao.imp.OrderDaoImp;
import com.jocata.order.entity.OrderEntity;
import com.jocata.order.form.OrderForm;
import com.jocata.order.service.OrderService;
import java.util.*;
public class OrderServiceImpl implements OrderService {

    public OrderEntity setOrderDetails(OrderForm form){
        OrderEntity entity = new OrderEntity();
        entity.setOrderId(form.getOrderId());
        entity.setItemName(form.getItemName());
        entity.setQuantity(form.getQuantity());
        entity.setOrderAddress(form.getOrderAddress());
        entity.setPhoneNumber(form.getPhoneNumber());
        entity.setCustomerName(form.getCustomerName());
        return entity;
    }

    public String createOrder(OrderForm form){

        OrderEntity entity = setOrderDetails(form);
        OrderDao dao = new OrderDaoImp();
        return dao.createOrder(entity);
    }

    public String updateOrder(OrderForm form){

        OrderEntity entity = setOrderDetails(form);
        OrderDao dao = new OrderDaoImp();
        return dao.updateOrder(entity);

    }

    public List<OrderForm> getAllOrders() {

        OrderDao dao = new OrderDaoImp();
        List<OrderEntity> entityList = dao.getAllOrders();
        List<OrderForm> formList = new ArrayList<>();

        for (OrderEntity entity : entityList) {
            OrderForm form = new OrderForm();
            form.setOrderId(String.valueOf(entity.getOrderId()));
            form.setItemName(entity.getItemName());
            form.setQuantity(String.valueOf(entity.getQuantity()));
            form.setOrderAddress(entity.getOrderAddress());
            form.setPhoneNumber(entity.getPhoneNumber());
            form.setCustomerName(entity.getCustomerName());

            formList.add(form);
        }

        return formList;
    }


    public OrderForm getOrder(String orderId) {
        OrderDao dao = new OrderDaoImp();
        Integer order = Integer.parseInt(orderId);
        OrderEntity entity = dao.getOrder(order);

        if (entity == null) {
            return null;
        }

        OrderForm form = new OrderForm();
        form.setOrderId(String.valueOf(entity.getOrderId()));
        form.setItemName(entity.getItemName());
        form.setQuantity(String.valueOf(entity.getQuantity()));
        form.setOrderAddress(entity.getOrderAddress());
        form.setPhoneNumber(entity.getPhoneNumber());
        form.setCustomerName(entity.getCustomerName());

        return form;
    }


    public String cancelOrder(String orderId){
        OrderDao dao = new OrderDaoImp();
        Integer order = Integer.parseInt(orderId);
        return dao.cancelOrder(order);

    }

    public static void closeService(){
       // OrderDaoImp.closeConnection();
    }
}
