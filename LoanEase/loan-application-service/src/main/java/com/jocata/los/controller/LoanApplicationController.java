package com.jocata.los.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jocata.los.datamodel.loanapplication.form.LoanApplicationRequest;
import com.jocata.los.datamodel.loanapplication.form.LoanApplicationResponse;
import com.jocata.los.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/loan")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @PostMapping(value = "/apply", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<LoanApplicationResponse> apply(
            @RequestPart("form") String formJson,
            @RequestPart("file") MultipartFile[] files) {

        ObjectMapper objectMapper = new ObjectMapper();
        LoanApplicationRequest form = null;
        try {
            form = objectMapper.readValue(formJson, LoanApplicationRequest.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        LoanApplicationResponse response = loanApplicationService.submitApplication(form, files);
        return ResponseEntity.ok(response);
    }


}
