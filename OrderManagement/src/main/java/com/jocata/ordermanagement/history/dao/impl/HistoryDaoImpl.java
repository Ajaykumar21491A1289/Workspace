package com.jocata.ordermanagement.history.dao.impl;

import com.jocata.ordermanagement.history.dao.HistoryDao;
import com.jocata.ordermanagement.ordermanager.entity.OrderEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryDaoImpl implements HistoryDao {

    private Map<Integer, OrderEntity> orderHistory = new HashMap<>();
    private Path path = Paths.get("D:\\Files\\orderHistoryObject.txt");

    public HistoryDaoImpl() {
        this.orderHistory = loadOrderHistoryData();
    }

    @Override
    public List<OrderEntity> getCompletedOrders() {
        List<OrderEntity> completedOrders = new ArrayList<>();
        for (OrderEntity order : orderHistory.values()) {
            if ("PAID".equalsIgnoreCase(order.getStatus())) {
                completedOrders.add(order);
            }
        }
        return completedOrders;
    }

    @Override
    public String addOrderHistory(OrderEntity orderEntity) {
        orderHistory.put(orderEntity.getOrderId(), orderEntity);
        saveOrderHistory();
        return "Order history added successfully";
    }


    private void saveOrderHistory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            oos.writeObject(orderHistory);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save order history data", e);
        }
    }

    private Map<Integer, OrderEntity> loadOrderHistoryData() {
        if (!Files.exists(path)) return new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            return (Map<Integer, OrderEntity>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
