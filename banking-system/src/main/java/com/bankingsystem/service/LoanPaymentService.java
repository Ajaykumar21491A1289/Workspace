package com.bankingsystem.service;


import com.bankingsystem.form.LoanPaymentForm;

import java.io.File;
import java.nio.file.Path;


public interface LoanPaymentService {

    String addLaonPayment(LoanPaymentForm form);

    String updateLoanPayment(LoanPaymentForm form);

    File getLaonPayment(String loanId);

    Path getAllLaonPayment();

    String deleteLaon(String loanId);
}
