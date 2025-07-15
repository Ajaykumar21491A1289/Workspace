package com.jocata.config;

import com.jocata.products.forms.ProductResForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class ProductClient {

    @Autowired
    private RestTemplate restTemplate;

    public BigDecimal getProductPrice(Long productId) {
        String url = "http://localhost:8080/PRODUCT-SERVICE/products/" + productId;
        ResponseEntity<ProductResForm> response = restTemplate.getForEntity(url, ProductResForm.class);
        return response.getBody().getPrice();
    }
}
