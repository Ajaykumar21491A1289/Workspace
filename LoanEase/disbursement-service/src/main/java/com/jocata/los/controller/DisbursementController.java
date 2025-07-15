package com.jocata.los.controller;


import com.jocata.los.datamodel.disbursment.form.DisbursementForm;
import com.jocata.los.service.DisbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disbursement")
public class DisbursementController {

    @Autowired
    private DisbursementService disbursementService;

    @PostMapping("/process")
    public ResponseEntity<DisbursementForm> disburse(@RequestBody DisbursementForm form) {
        DisbursementForm response = disbursementService.disburseLoan(form);
        return ResponseEntity.ok(response);
    }
}
