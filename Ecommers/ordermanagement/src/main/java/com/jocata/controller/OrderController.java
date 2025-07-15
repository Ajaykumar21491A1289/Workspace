package com.jocata.controller;

import com.jocata.orders.entity.OrderStatus;
import com.jocata.orders.entity.Orders;
import com.jocata.orders.entity.Payments;
import com.jocata.orders.forms.OrderInvoiceDto;
import com.jocata.orders.forms.OrderRequestDto;
import com.jocata.orders.forms.PaymentDto;
import com.jocata.service.OrderService;
import com.jocata.shipping.forms.TrackingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderRequestDto> placeOrder(@RequestBody OrderRequestDto dto) {
        OrderRequestDto order = orderService.placeOrder(dto);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{orderId}/track")
    public ResponseEntity<String> trackOrder(@PathVariable Long orderId) {
        String statuses = orderService.trackOrder(orderId);
        return ResponseEntity.ok(statuses);
    }

    @PostMapping("/{orderId}/payment")
    public ResponseEntity<PaymentDto> makePayment(@PathVariable Long orderId,
                                                @RequestBody PaymentDto paymentDto) {
        PaymentDto payment = orderService.makePayment(orderId, paymentDto);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/invoice/orderDetails/{orderId}")
    public ResponseEntity<OrderInvoiceDto> getOrderDetails(@PathVariable Long orderId) {
        OrderInvoiceDto dto = orderService.getOrderDetails(orderId);
        return ResponseEntity.ok(dto);
    }

}
