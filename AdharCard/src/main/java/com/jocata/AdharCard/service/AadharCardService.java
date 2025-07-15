package com.jocata.AdharCard.service;

import com.jocata.AdharCard.entity.PayLoad;
import com.jocata.AdharCard.form.AadharCardResForm;
import org.springframework.web.bind.annotation.RequestParam;

public interface AadharCardService {
    PayLoad getAadharCardDetails(String aadharId) throws Exception;
}
