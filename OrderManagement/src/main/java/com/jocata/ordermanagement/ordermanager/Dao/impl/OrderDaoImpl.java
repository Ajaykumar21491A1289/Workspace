package com.jocata.ordermanagement.ordermanager.Dao.impl;

import com.jocata.ordermanagement.ordermanager.Dao.OrderDao;
import com.jocata.ordermanagement.ordermanager.entity.OrderEntity;
import com.jocata.ordermanagement.ordermanager.form.OrderForm;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class OrderDaoImpl implements OrderDao {

    private List<OrderEntity> orderList;

    private Path path = Paths.get("D:\\Files\\orderObject.txt");

    public OrderDaoImpl() {
        this.orderList = loadOrderData();
    }

    @Override
    public String addOrder(OrderEntity orderEntity) {
        orderList.add(orderEntity);
        saveOrdersToFile();
        return "Order added successfully";
    }

    @Override
    public String updateOrder(OrderEntity orderEntity) {
        Iterator<OrderEntity> iterator = orderList.iterator();
        while (iterator.hasNext()) {
            OrderEntity order = iterator.next();
            if(order.getOrderId()==orderEntity.getOrderId()){
                iterator.remove();
                orderList.add(orderEntity);
                saveOrdersToFile();
                return "Order updated successfully";
            }

            }
        return "Order not found";
    }

    @Override
    public String cancelOrder(int orderId) {
        Iterator<OrderEntity> iterator = orderList.iterator();
        while (iterator.hasNext()) {
            OrderEntity order = iterator.next();
            if(order.getOrderId()==orderId){
                iterator.remove();
                saveOrdersToFile();
                return "Order Deleted successfully";
            }

        }
        return "Order not found";
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return new ArrayList<>(orderList);
    }

    @Override
    public OrderEntity getOrderDetails(int orderId) {
        for (OrderEntity order : orderList) {
            if (order.getOrderId()==orderId) {
                return order;
            }
        }
        return null;
    }


    private void saveOrdersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(orderList);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save orders to file", e);
        }
    }


    private List<OrderEntity> loadOrderData() {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                return new ArrayList<>();
            } catch (IOException e) {
                throw new RuntimeException("Failed to create file", e);
            }
        }
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            return (List<OrderEntity>) ois.readObject();
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load orders from file", e);
        }
    }



}
