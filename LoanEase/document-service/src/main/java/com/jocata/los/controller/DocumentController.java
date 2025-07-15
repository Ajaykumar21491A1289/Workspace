package com.jocata.los.controller;


import com.jocata.los.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/getSalary")
    public ResponseEntity<Double> uploadBankStatement(@RequestParam("file") MultipartFile file) {
        try {
            Double salary = documentService.processBankStatement(file);
            return ResponseEntity.ok(salary); // ✅ returning salary inside ResponseEntity
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // returning 500 error
        }
    }

}



