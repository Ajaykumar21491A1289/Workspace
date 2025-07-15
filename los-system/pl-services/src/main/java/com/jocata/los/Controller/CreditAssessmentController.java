package com.jocata.los.Controller;

import com.jocata.los.service.CreditAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3")
public class CreditAssessmentController {

    @Autowired
    CreditAssessmentService service;

    @GetMapping("/creditAssessment")
    public String creditAssessment(@RequestParam String loanId){
        return service.creditAssessment(loanId);
    }
}
