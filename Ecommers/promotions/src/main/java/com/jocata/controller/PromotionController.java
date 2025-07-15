package com.jocata.controller;

import com.jocata.promotions.forms.*;
import com.jocata.promotions.forms.res.*;
import com.jocata.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promoService;

    @PostMapping("/coupons")
    public ResponseEntity<CouponResponse> createCoupon(@RequestBody CouponForm req) {
        return ResponseEntity.ok(promoService.createCoupon(req));
    }

    @PostMapping("/discounts")
    public ResponseEntity<DiscountResponse> createDiscount(@RequestBody DiscountForm req) {
        return ResponseEntity.ok(promoService.addDiscount(req));
    }

    @PostMapping("/campaigns")
    public ResponseEntity<CampaignResponse> createCampaign(@RequestBody CampaignForm req) {
        return ResponseEntity.ok(promoService.createCampaign(req));
    }

    @GetMapping("/discounts/{productId}")
    public ResponseEntity<List<DiscountResponse>> getDiscounts(@PathVariable Long productId) {
        return ResponseEntity.ok(promoService.getDiscountsByProductId(productId));
    }

    @GetMapping("/coupons/{code}")
    public ResponseEntity<CouponResponse> getCouponByCode(@PathVariable String code) {
        return ResponseEntity.ok(promoService.getCouponByCode(code));
    }
}
