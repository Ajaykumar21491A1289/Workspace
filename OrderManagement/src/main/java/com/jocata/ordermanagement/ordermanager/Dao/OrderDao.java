package com.jocata.ordermanagement.ordermanager.Dao;

import com.jocata.ordermanagement.ordermanager.entity.OrderEntity;
import com.jocata.ordermanagement.ordermanager.form.OrderForm;

import java.util.List;

public interface OrderDao {
    String addOrder(OrderEntity orderEntity);
    String updateOrder(OrderEntity orderEntity);
    String cancelOrder(int orderId);

    List<OrderEntity> getAllOrders();
    OrderEntity getOrderDetails(int orderId);

}
