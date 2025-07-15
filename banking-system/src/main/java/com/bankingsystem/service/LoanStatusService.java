package com.bankingsystem.service;

import com.bankingsystem.form.LoanStatusForm;

import java.util.List;

public  interface LoanStatusService {

  String addlaonStatus(LoanStatusForm form);
  String updateLoanStatus(LoanStatusForm form);
  List<LoanStatusForm> getAllLaonStatus();
  String getLoan(Integer id);
  String deleteLoan(Integer id);
}
