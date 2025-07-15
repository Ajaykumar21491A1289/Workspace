package com.jocata.los.Controller;

import com.jocata.los.request.CreditReportForm;
import com.jocata.los.service.AddAccountDetailsToCibilApiService;
import com.jocata.los.service.LoanDisbursmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v6")
public class AddAccountDetailsToCibilApiController {

    @Autowired
    AddAccountDetailsToCibilApiService service;

    @GetMapping("/addAccountDetailsToCibilApi")
    public CreditReportForm addAccountDetailsToCibilApi(@RequestParam String loanId){
        return service.addAccountDetailsToCibilApi(loanId);
    }
}
