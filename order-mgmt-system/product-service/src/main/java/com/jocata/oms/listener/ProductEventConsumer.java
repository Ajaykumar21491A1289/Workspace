package com.jocata.oms.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductEventConsumer {

    @KafkaListener(topics = "order-topic", groupId = "product-group")
    public void processPayment(String orderId) {
        System.out.println("Processing payment for Order: " + orderId);
    }
}
