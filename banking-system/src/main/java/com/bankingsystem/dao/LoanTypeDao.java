package com.bankingsystem.dao;

import com.bankingsystem.entity.LoanTypeEntity;

import java.util.List;

public interface LoanTypeDao {

    String addLoanType(LoanTypeEntity entity);

    String updateLoanType(LoanTypeEntity entity);

    List<LoanTypeEntity> getAllLaonTypes();

    LoanTypeEntity getLoanType(Integer id);

    String deleteLaonType(Integer id);
}
