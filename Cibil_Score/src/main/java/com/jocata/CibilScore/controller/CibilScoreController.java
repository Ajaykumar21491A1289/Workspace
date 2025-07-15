package com.jocata.CibilScore.controller;

import com.jocata.CibilScore.Form.CreditReportForm;
import com.jocata.CibilScore.service.CibilScoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class CibilScoreController {

    @Autowired
    private CibilScoreService service;

    @PostMapping("/addingCreditDate")
    public CreditReportForm saveCibilScore( @RequestBody CreditReportForm form){
        return  service.saveCibilScore(form);
    }

    @GetMapping("/getCibilScoreDetails")
    public CreditReportForm getCibilScoreByPan(@RequestParam String panNumber){
        return service.getCreditReportByPan(panNumber);


    }



}
