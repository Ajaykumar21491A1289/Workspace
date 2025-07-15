package com.jocata.ordermanagementsystem.dao.imp;

import com.jocata.ordermanagementsystem.dao.OrderManagerDao;
import com.jocata.ordermanagementsystem.form.OrderForm;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class OrderManagerDaoImp implements OrderManagerDao {

    private List<OrderForm> orderList;
    private Path path = Paths.get("D:\\Notes\\orderObject.txt");

    public OrderManagerDaoImp() {
        this.orderList = loadOrderData();
    }

    @Override
    public String createOrder(OrderForm orderForm) {
        orderList.add(orderForm);
        saveOrdersToFile();
        return "Order Created Successfully";
    }

    @Override
    public String updateOrder(OrderForm orderForm) {
        for (OrderForm order : orderList) {
            if (order.getCustomerId().equals(orderForm.getCustomerId()) &&
                    order.getProductId().equals(orderForm.getProductId())) {
                order.setStatus(orderForm.getStatus());
                saveOrdersToFile();
                return "Order Updated Successfully";
            }
        }
        return "Order Not Found";
    }

    @Override
    public String cancelOrder(Integer index) {
        if (index >= 0 && index < orderList.size()) {
            orderList.remove((int) index);
            saveOrdersToFile();
            return "Order Cancelled Successfully";
        }
        return "Invalid Order Index";
    }


    @Override
    public OrderForm getOrder(Integer index) {
        if (index >= 0 && index < orderList.size()) {
            return orderList.get(index);
        }
        return null; // or throw exception if preferred
    }







    private void saveOrdersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(orderList);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save orders to file", e);
        }
    }

    private List<OrderForm> loadOrderData() {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                return new ArrayList<>();
            } catch (IOException e) {
                throw new RuntimeException("Failed to create file", e);
            }
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            return (List<OrderForm>) ois.readObject();
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load orders from file", e);
        }
    }
}
