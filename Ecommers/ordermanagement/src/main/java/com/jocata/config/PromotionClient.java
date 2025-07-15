package com.jocata.config;

import com.jocata.promotions.forms.res.CouponResponse;
import com.jocata.promotions.forms.res.DiscountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class PromotionClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String url = "http://localhost:8080/PROMOTIONS-SERVICE/promotions";

    public CouponResponse getCouponDetails(String code) {
        try {
            return restTemplate.getForObject(
                    url + "/coupons/" + code,
                    CouponResponse.class
            );
        } catch (Exception e) {
            CouponResponse res = new CouponResponse();
            res.setMessage("Invalid or expired coupon.");
            return res;
        }
    }

    public List<DiscountResponse> getDiscountsByProductId(Long productId) {
        try {
            String urls = url + "/discounts/" + productId;

            ResponseEntity<List<DiscountResponse>> response = restTemplate.exchange(
                    urls,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<DiscountResponse>>() {}
            );

            return response.getBody() != null ? response.getBody() : Collections.emptyList();

        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
