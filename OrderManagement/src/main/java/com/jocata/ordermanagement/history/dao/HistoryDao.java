package com.jocata.ordermanagement.history.dao;

import com.jocata.ordermanagement.ordermanager.entity.OrderEntity;

import java.util.List;

public interface HistoryDao {


    List<OrderEntity> getCompletedOrders();
    String addOrderHistory(OrderEntity orderEntity);
}
