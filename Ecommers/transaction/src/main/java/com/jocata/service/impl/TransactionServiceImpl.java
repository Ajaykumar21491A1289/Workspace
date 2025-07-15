package com.jocata.service.impl;

import com.jocata.config.OrderClient;
import com.jocata.config.ProductClient;
import com.jocata.config.UserClient;
import com.jocata.dao.transaction.BillingInfoRepository;
import com.jocata.dao.transaction.InvoiceRepository;
import com.jocata.dao.transaction.PaymentMethodRepository;
import com.jocata.dao.transaction.TransactionRepository;
import com.jocata.orders.entity.Orders;
import com.jocata.orders.forms.OrderInvoiceDto;
import com.jocata.service.TransactionService;
import com.jocata.transaction.entity.BillingInfo;
import com.jocata.transaction.entity.Invoice;
import com.jocata.transaction.entity.PaymentMethos;
import com.jocata.transaction.entity.Transaction;
import com.jocata.transaction.forms.InvoiceRes;
import com.jocata.transaction.forms.TransactionReq;
import com.jocata.transaction.forms.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private UserClient userClient;

    @Autowired
    private BillingInfoRepository billingRepo;

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private PaymentMethodRepository methodRepo;

    @Autowired
    private ProductClient productClient;

    @Transactional
    @Override
    public TransactionResponse processTransaction(TransactionReq request) {

        Transaction tx = saveTransaction(request);

        saveBillingInfo(request);

        Invoice invoice = saveInvoice(tx.getId(), request.getAmount());

        savePaymentMethod(request.getPaymentMethod());

        TransactionResponse response = new TransactionResponse();
        response.setTransactionId(tx.getId());
        response.setMessage("Transaction successful");
        response.setInvoiceDate(invoice.getInvoiceDate());
        response.setAmount(request.getAmount());
        return response;
    }

    private Transaction saveTransaction(TransactionReq request) {
        Transaction tx = new Transaction();
        tx.setOrderId(request.getOrderId());
        tx.setAmount(request.getAmount());
        tx.setStatus(request.getStatus());
        return transactionRepo.save(tx);
    }

    private void saveBillingInfo(TransactionReq request) {
        BillingInfo billing = new BillingInfo();
        billing.setUserId(request.getUserId());
        billing.setCardNumber(request.getCardNumber());
        billing.setExpirationDate(request.getExpirationDate());
        billing.setBillingAddress(request.getBillingAddress());
        billingRepo.save(billing);
    }

    private Invoice saveInvoice(Long transactionId, java.math.BigDecimal amount) {
        Invoice invoice = new Invoice();
        invoice.setTransactionId(transactionId);
        invoice.setAmount(amount);
        return invoiceRepo.save(invoice);
    }

    private void savePaymentMethod(String methodName) {
        PaymentMethos method = new PaymentMethos();
        method.setMethodName(methodName);
        method.setDescription("Auto-inserted");
        methodRepo.save(method);
    }

    @Override
    public InvoiceRes getInvoiceByTransactionId(Long transactionId) {
        Invoice invoice = invoiceRepo.findByTransactionId(transactionId).orElse(null);

        if (invoice == null) {
            InvoiceRes res = new InvoiceRes();
            res.setMessage("Invoice not found for Transaction ID: " + transactionId);
            return res;
        }

        return mapToFullInvoiceResponse(invoice);
    }

    private InvoiceRes mapToFullInvoiceResponse(Invoice invoice)  {
        InvoiceRes response = new InvoiceRes();

        response.setId(invoice.getId());
        response.setTransactionId(invoice.getTransactionId());
        response.setInvoiceDate(invoice.getInvoiceDate().toString());
        response.setAmount(invoice.getAmount());

        Transaction tx = transactionRepo.findById(invoice.getTransactionId()).orElse(null);
        if (tx == null) {
            response.setMessage("Transaction data not found");
            return response;
        }

        response.setOrderId(tx.getOrderId());

        OrderInvoiceDto orderDetails = orderClient.getOrderDetails(tx.getOrderId());

        if (orderDetails != null) {
            response.setShippingAddress(orderDetails.getShippingAddress());

            String userName = userClient.getUserName(orderDetails.getUserId());
            response.setUserName(userName);

            List<InvoiceRes.OrderItemDetails> itemDetails = new ArrayList<>();

            for (OrderInvoiceDto.ItemDetail item : orderDetails.getItems()) {
                InvoiceRes.OrderItemDetails detail = new InvoiceRes.OrderItemDetails();
                detail.setProductName(productClient.getProductName(item.getProductId()));
                detail.setQuantity(item.getQuantity());
                detail.setPrice(item.getPrice());
                itemDetails.add(detail);
            }
            response.setItems(itemDetails);
        }

        response.setTransactionDate(tx.getTransactionDate());


        response.setMessage("Invoice fetched successfully");
        return response;
    }

}
