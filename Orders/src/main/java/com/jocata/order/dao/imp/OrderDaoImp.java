package com.jocata.order.dao.imp;

import com.jocata.order.dao.OrderDao;
import com.jocata.order.entity.OrderEntity;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import static java.nio.file.Files.newBufferedWriter;

public class OrderDaoImp implements OrderDao {

    private List<OrderEntity> orders;
    private  Path path = Paths.get("C:\\Workspace\\Orders\\src\\main\\java\\com\\jocata\\order\\dao\\imp\\objects.txt");

    public OrderDaoImp() {

        this.orders = loadOrdersFromFile();
    }

    @Override
    public String createOrder(OrderEntity entity) {
        orders.add(entity);
        saveOrdersToFile();
        return "Order created successfully.";
    }

    @Override
    public String updateOrder(OrderEntity entity) {
        for (OrderEntity order : orders) {
            if (order.getOrderId().equals(entity.getOrderId())) {
                order.setItemName(entity.getItemName());
                order.setEntityQuantity(entity.getQuantity());
                order.setOrderAddress(entity.getOrderAddress());
                order.setPhoneNumber(entity.getPhoneNumber());
                order.setCustomerName(entity.getCustomerName());
                saveOrdersToFile();
                return "Order updated successfully.";
            }
        }
        return "Order not found.";
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        for(OrderEntity order:orders) loadDetailsIntoFile(order);
        return new ArrayList<>(orders);
    }

    @Override
    public OrderEntity getOrder(Integer orderId) {
        for (OrderEntity order : orders) {
            if (order.getOrderId().equals(orderId)) {
                loadDetailsIntoFile(order);
                return order;
            }
        }
        return null;
    }

    @Override
    public String cancelOrder(Integer orderId) {
        Iterator<OrderEntity> iterator = orders.iterator();
        while (iterator.hasNext()) {
            OrderEntity order = iterator.next();
            if (order.getOrderId().equals(orderId)) {
                iterator.remove();
                saveOrdersToFile();
                return "Order cancelled successfully.";
            }
        }
        return "Order not found.";
    }


    private void saveOrdersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(orders);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save orders to file", e);
        }
    }

    // Load orders list from file using ObjectInputStream
    @SuppressWarnings("unchecked")
    private List<OrderEntity> loadOrdersFromFile() {

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
            // File is empty
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load orders from file", e);
        }
    }

    private void loadDetailsIntoFile(OrderEntity order) {
        Path dataPath = Paths.get("C:\\Workspace\\Orders\\src\\main\\java\\com\\jocata\\order\\dao\\imp\\data.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(dataPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(order.getOrderId() + "," +
                    order.getItemName() + "," +
                    order.getQuantity() + "," +
                    order.getOrderAddress() + "," +
                    order.getPhoneNumber() + "," +
                    order.getCustomerName());

            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write order details to file", e);
        }
    }



}

