package com.jocata.ordermanagement.history.service;

import com.jocata.ordermanagement.ordermanager.entity.OrderEntity;

import java.util.List;

public interface HistoryService {

    List<OrderEntity> getCompletedOrders();


}
