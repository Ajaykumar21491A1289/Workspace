package com.jocata.los.Controller;

import com.jocata.los.form.CustomerForm;
import com.jocata.los.form.LoanApplicationForm;
import com.jocata.los.form.LoanDetailsForm;
import com.jocata.los.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LoanApplicationController {

    @Autowired
    LoanApplicationService service;

    @PostMapping("/addLoan")
   public LoanDetailsForm addLaonApplication(@RequestBody LoanDetailsForm form){

           return service.addLaonApplication(form);

   }

   @GetMapping("/getLaon")
    public LoanDetailsForm getLoanApplication(@RequestParam String  applicationId){
        return service.getLaonApplication(applicationId);
   }




}
