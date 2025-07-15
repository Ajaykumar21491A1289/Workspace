package com.jocata.los.Controller;

import com.jocata.los.service.LoanProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v4")
public class LoanProcessController {

    @Autowired
    LoanProcessService service;

    @GetMapping("/loanProcess")
    public String loanProcess(@RequestParam String requiredAmount, @RequestParam String loanId){
        return service.loanProcess(requiredAmount,loanId);
    }
}
