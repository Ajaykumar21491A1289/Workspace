package com.bankingsystem.dao;

import com.bankingsystem.entity.LoanPaymentEntity;

import java.io.File;
import java.nio.file.Path;

public interface LoanPaymentDao {

    String addLaonPayment(LoanPaymentEntity form);

    String updateLoanPayment(LoanPaymentEntity form);

    File getLaonPayment(Integer loanId);

    Path getAllLaonPayment();

    String deleteLaon(Integer loanId);

    int getPaymentCountForLoan(int loanId);

}
