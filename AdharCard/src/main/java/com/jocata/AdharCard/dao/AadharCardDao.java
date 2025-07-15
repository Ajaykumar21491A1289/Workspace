package com.jocata.AdharCard.dao;

import com.jocata.AdharCard.form.AadharCardResForm;
import org.springframework.web.bind.annotation.RequestParam;

public interface AadharCardDao {
    String getAadharCardDetails() throws Exception;
}
