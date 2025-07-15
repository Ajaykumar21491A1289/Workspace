package com.jocata.ordermanagementsystem.service.imp;

import com.jocata.ordermanagementsystem.dao.OrderHistoryDao;
import com.jocata.ordermanagementsystem.dao.imp.OrderHistoryDaoImp;
import com.jocata.ordermanagementsystem.form.OrderForm;
import com.jocata.ordermanagementsystem.service.OrderHistoryService;

import java.util.List;

public class OrderHistoryServiceImp implements OrderHistoryService {

    private OrderHistoryDao orderHistoryDao;

    public OrderHistoryServiceImp() {
        this.orderHistoryDao = new OrderHistoryDaoImp();
    }

    @Override
    public void saveOrderToHistory(OrderForm orderForm) {
        orderHistoryDao.saveCompletedOrder(orderForm);
    }

    @Override
    public List<OrderForm> getCompletedOrders() {
        return orderHistoryDao.getAllCompletedOrders();
    }
}
