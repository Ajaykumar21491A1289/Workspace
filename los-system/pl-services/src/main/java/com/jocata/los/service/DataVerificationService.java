package com.jocata.los.service;

import org.springframework.web.bind.annotation.RequestParam;

public interface DataVerificationService {
    String getCustomerData(String loanAppId);
}
