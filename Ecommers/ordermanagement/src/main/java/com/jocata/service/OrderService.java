package com.jocata.service;

import com.jocata.orders.entity.OrderStatus;
import com.jocata.orders.entity.Orders;
import com.jocata.orders.entity.Payments;
import com.jocata.orders.forms.OrderInvoiceDto;
import com.jocata.orders.forms.OrderRequestDto;
import com.jocata.orders.forms.PaymentDto;

import java.util.List;

public interface OrderService {


    OrderRequestDto placeOrder(OrderRequestDto dto);

    String trackOrder(Long orderId);

    PaymentDto makePayment(Long orderId, PaymentDto paymentDto);

    OrderInvoiceDto getOrderDetails(Long orderId);

}
