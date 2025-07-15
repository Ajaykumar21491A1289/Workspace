package com.jocata.oms.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRestClient {

    private static final Logger logger = LoggerFactory.getLogger(UserRestClient.class);

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "order-service", fallbackMethod = "fallbackUserResponse")
    public String getUser() {
        try {
            logger.info("🔄 Retrying User Service...");
            String url = "http://localhost:8081/user-service/api/getUser/1";
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException ex) {
            logger.warn("⚠️ User Service failed, will retry...");
            throw new RuntimeException("User service is down! Retrying...", ex);
        }
    }

    public String fallbackUserResponse(Throwable ex) {
        logger.error("🔥 Circuit Breaker Triggered for User Service: {}", ex.getMessage());
        return "Fallback: User service is down.";
    }
}
