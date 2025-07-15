package com.jocata.ordermanagementsystem.service.imp;

import com.jocata.ordermanagementsystem.dao.OrderHistoryDao;
import com.jocata.ordermanagementsystem.dao.OrderManagerDao;
import com.jocata.ordermanagementsystem.dao.imp.OrderHistoryDaoImp;
import com.jocata.ordermanagementsystem.dao.imp.OrderManagerDaoImp;
import com.jocata.ordermanagementsystem.form.OrderForm;
import com.jocata.ordermanagementsystem.service.OrderManagerService;

import java.util.List;

public class OrderManagerServiceImp implements OrderManagerService {

    private OrderManagerDao orderDao = new OrderManagerDaoImp();
    private OrderHistoryDao historyDao = new OrderHistoryDaoImp();

    @Override
    public String createOrder(OrderForm orderForm) {

        String result =orderDao.updateOrder(orderForm);
        if ("COMPLETED".equalsIgnoreCase(orderForm.getStatus()) || "PAID".equalsIgnoreCase(orderForm.getStatus())) {
            historyDao.saveCompletedOrder(orderForm);
        }
        return orderDao.createOrder(orderForm);
    }

    @Override
    public String updateOrder(OrderForm orderForm) {
        String result =orderDao.updateOrder(orderForm);
        if ("COMPLETED".equalsIgnoreCase(orderForm.getStatus()) || "PAID".equalsIgnoreCase(orderForm.getStatus())) {
            historyDao.saveCompletedOrder(orderForm);
        }
        return result;

    }

    @Override
    public String cancelOrder(Integer orderId) {
        return orderDao.cancelOrder(orderId);
    }

    @Override
    public OrderForm getOrder(Integer orderId) {
        return orderDao.getOrder(orderId);
    }



}
