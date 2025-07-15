package com.jocata.service.impl;

import com.jocata.dao.promotions.*;
import com.jocata.promotions.entity.*;
import com.jocata.promotions.forms.*;
import com.jocata.promotions.forms.res.*;
import com.jocata.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private CouponRepository couponRepo;
    @Autowired
    private DiscountRepository discountRepo;
    @Autowired
    private CampaignRepository campaignRepo;

    @Override
    public CouponResponse createCoupon(CouponForm req) {
        CouponResponse response = new CouponResponse();
        Optional<Coupn> existing = couponRepo.findByCode(req.code);
        if (existing.isPresent()) {
            response.message = "Coupon already exists";
            return response;
        }

        Coupn coupon = new Coupn();
        coupon.setCode(req.code);
        coupon.setDiscountPercentage(req.discountPercentage);
        coupon.setExpirationDate(req.expirationDate);
        Coupn saved = couponRepo.save(coupon);

        response.id = saved.getId();
        response.code = saved.getCode();
        response.discountPercentage = saved.getDiscountPercentage();
        response.expirationDate = saved.getExpirationDate();
        response.message = "Coupon created successfully";
        return response;
    }

    @Override
    public DiscountResponse addDiscount(DiscountForm req) {
        DiscountResponse response = new DiscountResponse();
        Optional<Coupn> optionalCoupon = couponRepo.findById(req.couponId);

        if (optionalCoupon.isEmpty()) {
            response.message = "Coupon not found";
            return response;
        }

        Discount discount = new Discount();
        discount.setCoupon(optionalCoupon.get());
        discount.setProductId(req.productId);
        discount.setDiscountAmount(req.discountAmount);
        Discount saved = discountRepo.save(discount);

        response.id = saved.getId();
        response.productId = saved.getProductId();
        response.discountAmount = saved.getDiscountAmount();
        response.couponCode = saved.getCoupon().getCode();
        response.message = "Discount added successfully";
        return response;
    }

    @Override
    public CampaignResponse createCampaign(CampaignForm req) {
        Campaign campaign = new Campaign();
        campaign.setCampaignName(req.campaignName);
        campaign.setStartDate(req.startDate);
        campaign.setEndDate(req.endDate);
        Campaign saved = campaignRepo.save(campaign);

        CampaignResponse response = new CampaignResponse();
        response.id = saved.getId();
        response.campaignName = saved.getCampaignName();
        response.startDate = saved.getStartDate();
        response.endDate = saved.getEndDate();
        response.message = "Campaign created successfully";
        return response;
    }

    @Override
    public List<DiscountResponse> getDiscountsByProductId(Long productId) {
        List<Discount> discounts = discountRepo.findByProductId(productId);
        return discounts.stream().map(d -> {
            DiscountResponse resp = new DiscountResponse();
            resp.id = d.getId();
            resp.productId = d.getProductId();
            resp.discountAmount = d.getDiscountAmount();
            resp.couponCode = d.getCoupon().getCode();
            resp.message = "Discount fetched successfully";
            return resp;
        }).collect(Collectors.toList());
    }

    @Override
    public CouponResponse getCouponByCode(String code) {
        CouponResponse response = new CouponResponse();
        Coupn coupon = couponRepo.findByCode(code).orElse(null);
        if (coupon == null) {
            response.setMessage("Coupon not found");
            return response;
        }

        response.code = coupon.getCode();
        response.discountPercentage = coupon.getDiscountPercentage();
        response.expirationDate = coupon.getExpirationDate();
        response.message = "Coupon retrieved successfully";
        return response;
    }
}
