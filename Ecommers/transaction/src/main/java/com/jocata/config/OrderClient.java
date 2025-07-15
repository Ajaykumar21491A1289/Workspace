package com.jocata.config;

import com.jocata.orders.forms.OrderInvoiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderClient {

    @Autowired
    private RestTemplate restTemplate;

    public OrderInvoiceDto getOrderDetails(Long orderId) {
        String url = "http://localhost:8080/ORDER-SERVICE/orders/invoice/orderDetails/" + orderId;
        return restTemplate.getForObject(url, OrderInvoiceDto.class);
    }
}
