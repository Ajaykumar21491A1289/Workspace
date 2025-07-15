package com.jocata.controller;

import com.jocata.service.TransactionService;
import com.jocata.transaction.forms.InvoiceRes;
import com.jocata.transaction.forms.TransactionReq;
import com.jocata.transaction.forms.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/process")
    public ResponseEntity<TransactionResponse> process(@RequestBody TransactionReq request) {
        return ResponseEntity.ok(transactionService.processTransaction(request));
    }

    @GetMapping("/invoice/{transactionId}")
    public ResponseEntity<InvoiceRes> getInvoice(@PathVariable Long transactionId) {
        return ResponseEntity.ok(transactionService.getInvoiceByTransactionId(transactionId));
    }


}
