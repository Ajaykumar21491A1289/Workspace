package com.jocata.los.service.impl;

import com.jocata.los.request.CreditReportForm;
import com.jocata.los.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public CreditReportForm addAccountDetails(CreditReportForm form) {
        try{

            String url ="http://localhost:8082/cibilscore/api/v3/addingCreditDate";
            CreditReportForm response = restTemplate.postForObject(url,form,CreditReportForm.class);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
