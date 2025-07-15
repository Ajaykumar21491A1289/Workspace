package com.bankingsystem.service;

import com.bankingsystem.form.LoanForm;

public interface LoanService {

    String addLoan(LoanForm form);
    void getAllLoans();
    void getLoan(Integer Id);
    void updateLoan(LoanForm form);
    void deleteLoan(Integer id);
    public String approveLoan(Integer loanID);
}
