package com.jocata.service;

import com.jocata.promotions.forms.CampaignForm;
import com.jocata.promotions.forms.CouponForm;
import com.jocata.promotions.forms.DiscountForm;
import com.jocata.promotions.forms.res.CampaignResponse;
import com.jocata.promotions.forms.res.CouponResponse;
import com.jocata.promotions.forms.res.DiscountResponse;

import java.util.List;

public interface PromotionService {

    CouponResponse createCoupon(CouponForm req);
    DiscountResponse addDiscount(DiscountForm req);
    CampaignResponse createCampaign(CampaignForm req);
    List<DiscountResponse> getDiscountsByProductId(Long productId);

    CouponResponse getCouponByCode(String code);
}

