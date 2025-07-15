package com.jocata.service;

import com.jocata.transaction.forms.InvoiceRes;
import com.jocata.transaction.forms.TransactionReq;
import com.jocata.transaction.forms.TransactionResponse;

public interface TransactionService {
    TransactionResponse processTransaction(TransactionReq request);

    InvoiceRes getInvoiceByTransactionId(Long orderId);
}
