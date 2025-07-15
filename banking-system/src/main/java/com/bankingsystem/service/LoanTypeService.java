package com.bankingsystem.service;

import com.bankingsystem.form.LoanTypeForm;

import java.util.List;

public interface LoanTypeService {

    String addLoanType(LoanTypeForm form);

    String updateLoanType(LoanTypeForm form);

    List<LoanTypeForm> getAllLaonTypes();

    LoanTypeForm getLoanType(Integer id);

    String deleteLaonType(Integer id);
}
