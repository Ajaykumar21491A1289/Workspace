// OrderHistoryDao.java
package com.jocata.ordermanagementsystem.dao;

import com.jocata.ordermanagementsystem.form.OrderForm;
import java.util.List;

public interface OrderHistoryDao {
    void saveCompletedOrder(OrderForm orderForm);
    List<OrderForm> getAllCompletedOrders();
}
