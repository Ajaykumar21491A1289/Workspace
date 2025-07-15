package com.bankingsystem.controller;

import com.bankingsystem.form.LoanPaymentForm;
import com.bankingsystem.service.LoanPaymentService;
import com.bankingsystem.service.imp.LoanPaymentServiceImp;

import java.io.File;
import java.nio.file.Path;


public class LoanPaymentController {

    LoanPaymentService service = new LoanPaymentServiceImp();

    public String addLaonPayment(LoanPaymentForm form) {
        if (form.getLoanID() != null && !form.getLoanID().isEmpty()) {
            return service.addLaonPayment(form);
        }
        return "Not Added";
    }

    public String updateLoanPayment(LoanPaymentForm form) {

        if (form.getPaymentId() != null && !form.getPaymentId().isEmpty() &&
                form.getLoanID() != null && !form.getLoanID().isEmpty() &&
                form.getPaymentDate() != null && !form.getPaymentDate().isEmpty() &&
                form.getAmountPaid() != null && !form.getAmountPaid().isEmpty()) {
            return service.updateLoanPayment(form);

        }
        return " Not Updated";

    }

    public File getLaonPayment(String loanId) {
        if (loanId != null && !loanId.isEmpty()) {
            return service.getLaonPayment(loanId);
        }
        return null;
    }

    public Path getAllLaonPayment() {
        return service.getAllLaonPayment();

    }

    public String deleteLaon(String loanId) {
        if (loanId != null && !loanId.isEmpty()) {
            return service.deleteLaon(loanId);

        }
        return " Loan Id Not Found ";
    }
}
