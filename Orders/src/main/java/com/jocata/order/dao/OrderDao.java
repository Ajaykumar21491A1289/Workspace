package com.jocata.order.dao;

import com.jocata.order.entity.OrderEntity;
import java.util.*;
public interface OrderDao {

    public  String createOrder(OrderEntity entity);

    public String updateOrder(OrderEntity entity);

    public List<OrderEntity> getAllOrders();

    public OrderEntity getOrder(Integer orderId);

    public String cancelOrder(Integer orderId);
}
