package com.bankingsystem.dao;

import com.bankingsystem.entity.LoanStatusEntity;

import java.util.List;

public interface LoanStatusDao {

    String addLaonStatus(LoanStatusEntity entity);
    String updateLoanStatus(LoanStatusEntity entity);
    List<LoanStatusEntity> getAllLoanStatus();
    String getLoan(Integer id);
    String deleteLoan(Integer id);
}
