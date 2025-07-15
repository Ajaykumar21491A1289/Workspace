package com.jocata.los.Controller;

import com.jocata.los.EmiCalculator;
import com.jocata.los.service.LoanDisbursmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v5")
public class LoanDisbursmentController {

    @Autowired
    LoanDisbursmentService service;

    @RequestMapping("/loanDisbursment")
    public List<EmiCalculator.EmiMonth> loanDisbursment(@RequestParam String loanId){
        return service.loanDisbursment(loanId);

    }
}
