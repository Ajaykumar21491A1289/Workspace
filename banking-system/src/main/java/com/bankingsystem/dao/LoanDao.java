package com.bankingsystem.dao;

import com.bankingsystem.entity.LoanEntity;
import com.bankingsystem.entity.LoanResponseEntity;


import java.util.List;

public interface LoanDao {

    String addLoan(LoanEntity entity);
    List<LoanResponseEntity> getAllLaons();
    LoanResponseEntity getLoan(Integer loanId);
    String updateLoan(LoanEntity entity);
    String deleteLoan(Integer id);
    String approveLoan(Integer loanID);
}
