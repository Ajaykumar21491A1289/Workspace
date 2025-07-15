package com.jocata.ordermanagement.history.controller;

import com.jocata.ordermanagement.history.service.HistoryService;
import com.jocata.ordermanagement.history.service.impl.HistoryServiceImpl;
import com.jocata.ordermanagement.ordermanager.entity.OrderEntity;

import java.util.List;

public class HistoryController {

    HistoryService service = new HistoryServiceImpl();

    public List<OrderEntity> getCompletedOrders() {
        return service.getCompletedOrders();
    }
}
