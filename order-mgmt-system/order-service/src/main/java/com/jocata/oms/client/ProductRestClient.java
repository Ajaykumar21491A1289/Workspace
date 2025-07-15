package com.jocata.oms.client;

import com.jocata.oms.controller.OrderController;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductRestClient {

    private static final Logger logger = LoggerFactory.getLogger(ProductRestClient.class);

    @Autowired
    private RestTemplate restTemplate;

    @Retry(name = "order-service")
    @CircuitBreaker(name = "order-service", fallbackMethod = "fallbackProductResponse")
    public String getProduct() {
        try {
            logger.info("🔄 Retrying Product Service...");
            String url = "http://localhost:8082/product-service/api/getProduct/1";
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException ex) {
            logger.warn("⚠️ Product Service failed, will retry...");
            throw new RuntimeException("Product service is down! Retrying...", ex);
        }
    }

    public String fallbackProductResponse(Throwable ex) {
        logger.error("🔥 Circuit Breaker Triggered for Product Service: {}", ex.getMessage());
        return "Fallback: Product service is down.";
    }
}
