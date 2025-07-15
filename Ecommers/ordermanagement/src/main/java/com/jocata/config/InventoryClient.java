package com.jocata.config;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InventoryClient {

    @Autowired
    private RestTemplate restTemplate;

    public boolean reduceStock(Long productId,Integer quantity){
        String url = "http://localhost:8080/INVENTORY-SERVICE/inventory/reduceStock/{productId}/{quantity}";
        try {
            ResponseEntity<Void> response = restTemplate.getForEntity(url, Void.class, productId, quantity);
            return response.getStatusCode().is2xxSuccessful();
        }catch(Exception e){
            return false;
        }

    }

    public int getAvailableQuantity(Long productId) {
        String url ="http://localhost:8080/INVENTORY-SERVICE/inventory/product/{productId}/quantity";
        ResponseEntity<Integer> response = restTemplate.getForEntity(url, Integer.class,productId);
        return response.getBody();
    }
}
