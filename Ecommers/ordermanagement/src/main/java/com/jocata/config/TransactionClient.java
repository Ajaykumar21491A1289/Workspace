package com.jocata.config;

import com.jocata.orders.forms.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class TransactionClient {

    @Autowired
    private RestTemplate restTemplate;

    public void createTransaction(PaymentDto dto) {
        String url = "http://localhost:8080/TRANSACTION-SERVICE/transactions/process"; // adjust to your actual endpoint
        restTemplate.postForEntity(url, dto, Void.class);
    }
}