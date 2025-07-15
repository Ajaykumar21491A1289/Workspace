package com.jocata.ordermanagementsystem.service;

import com.jocata.ordermanagementsystem.form.OrderForm;
import java.util.List;

public interface OrderHistoryService {
    void saveOrderToHistory(OrderForm orderForm);
    List<OrderForm> getCompletedOrders();
}
