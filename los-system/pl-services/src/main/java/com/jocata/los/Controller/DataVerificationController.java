package com.jocata.los.Controller;

import com.jocata.los.service.DataVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class DataVerificationController {

    @Autowired
    DataVerificationService service;

    @GetMapping("/verification")
    public String getCustomerData(@RequestParam String loanAppId){
       return service.getCustomerData(loanAppId);

    }
}
