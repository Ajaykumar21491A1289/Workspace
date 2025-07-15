package com.jocata.ordermanagement.history.service.impl;

import com.jocata.ordermanagement.history.dao.HistoryDao;
import com.jocata.ordermanagement.history.dao.impl.HistoryDaoImpl;
import com.jocata.ordermanagement.history.service.HistoryService;
import com.jocata.ordermanagement.ordermanager.entity.OrderEntity;

import java.util.List;

public class HistoryServiceImpl implements HistoryService {


    HistoryDao dao = new HistoryDaoImpl();


    public List<OrderEntity> getCompletedOrders() {
        return dao.getCompletedOrders();
    }
}
