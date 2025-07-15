package com.jocata.ordermanagement.ordermanager.service.impl;

import com.jocata.ordermanagement.history.dao.impl.HistoryDaoImpl;
import com.jocata.ordermanagement.inventoryManagement.dao.InventoryDao;
import com.jocata.ordermanagement.inventoryManagement.dao.impl.InventoryDaoImpl;
import com.jocata.ordermanagement.ordermanager.Dao.OrderDao;
import com.jocata.ordermanagement.ordermanager.Dao.impl.OrderDaoImpl;
import com.jocata.ordermanagement.ordermanager.entity.OrderEntity;
import com.jocata.ordermanagement.ordermanager.form.OrderForm;
import com.jocata.ordermanagement.ordermanager.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    InventoryDao inventoryDao = new InventoryDaoImpl();

    OrderDao dao = new OrderDaoImpl();
    HistoryDaoImpl historyDao = new HistoryDaoImpl();


    public OrderEntity addDetailsToEntity(OrderForm form){
        OrderEntity entity = new OrderEntity();
        entity.setOrderId(Integer.parseInt(form.getOrderId()));
        entity.setCustomerId(Integer.parseInt(form.getCustomerId()));
        entity.setStatus(form.getStatus());
        entity.setProductIds(form.getProductIds());
        return entity;
    }

    public OrderForm addDetailsToForm(OrderEntity entity){
        OrderForm form = new OrderForm();
        form.setOrderId(String.valueOf(entity.getOrderId()));
        form.setCustomerId(String.valueOf(entity.getCustomerId()));
        form.setProductIds(entity.getProductIds());
        form.setStatus(entity.getStatus());
        return form;
    }


    @Override
    public String addOrder(OrderForm form) {

        for(Integer productId:form.getProductIds()){
            if(inventoryDao.getProductDetails(productId)==null){
                return "Product Not Found ";
            }
        }

        OrderEntity entity = addDetailsToEntity(form);
        String result = dao.addOrder(entity);
        if ("PAID".equalsIgnoreCase(entity.getStatus())) {
            historyDao.addOrderHistory(entity);
        }
        return result;
    }

    @Override
    public String updateOrder(OrderForm form) {
        if (getOrder(Integer.valueOf(form.getOrderId())) != null) {
            OrderEntity entity = addDetailsToEntity(form);
            String result = dao.updateOrder(entity);
            if ("PAID".equalsIgnoreCase(entity.getStatus())) {
                historyDao.addOrderHistory(entity);
            }
            return result;
        }
        return "Order Does not exist";
    }

    @Override
    public String cancelOrder(int orderId) {
        return dao.cancelOrder(orderId);
    }

    @Override
    public List<OrderForm> getAllOrders() {
        List<OrderEntity> list =  dao.getAllOrders();
        List<OrderForm> forms = new ArrayList<>();
        for(OrderEntity entity : list){
           forms.add( addDetailsToForm(entity));
        }
        return forms;

    }

    @Override
    public OrderForm getOrder(Integer orderId) {
        return addDetailsToForm(dao.getOrderDetails(orderId));
    }


}
