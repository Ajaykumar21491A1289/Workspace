package com.jocata.los.controller;

import com.jocata.los.datamodel.approval.form.ApprovalRequestForm;
import com.jocata.los.service.ApprovalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/approval")
public class ApprovalRequestController {

    @Autowired
    private ApprovalRequestService approvalRequestService;

    @PostMapping("/submit")
    public ResponseEntity<ApprovalRequestForm> submitApproval(@RequestBody ApprovalRequestForm form) {
        ApprovalRequestForm response = approvalRequestService.processApproval(form);
        return ResponseEntity.ok(response);
    }
}
