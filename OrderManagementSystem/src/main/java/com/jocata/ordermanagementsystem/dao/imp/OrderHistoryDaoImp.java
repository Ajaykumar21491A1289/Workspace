// OrderHistoryDaoImp.java
package com.jocata.ordermanagementsystem.dao.imp;

import com.jocata.ordermanagementsystem.dao.OrderHistoryDao;
import com.jocata.ordermanagementsystem.form.OrderForm;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryDaoImp implements OrderHistoryDao {

    private List<OrderForm> completedOrders;
    private Path path = Paths.get("D:\\Notes\\completedOrders.txt");

    public OrderHistoryDaoImp() {
        this.completedOrders = loadCompletedOrders();
    }

    @Override
    public void saveCompletedOrder(OrderForm orderForm) {
        completedOrders.add(orderForm);
        saveOrdersToFile();
    }

    @Override
    public List<OrderForm> getAllCompletedOrders() {
        return new ArrayList<>(completedOrders);
    }

    private void saveOrdersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(completedOrders);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save completed orders", e);
        }
    }

    private List<OrderForm> loadCompletedOrders() {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                return new ArrayList<>();
            } catch (IOException e) {
                throw new RuntimeException("Failed to create file for completed orders", e);
            }
        }
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            return (List<OrderForm>) ois.readObject();
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load completed orders", e);
        }
    }
}
