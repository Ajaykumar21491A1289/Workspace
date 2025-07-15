package com.bankingsystem.dao;

import com.bankingsystem.entity.LoanBranchEntity;

import java.util.List;

public interface LoanBranchDao {
    String addBranch(LoanBranchEntity entity);
    List<LoanBranchEntity> getAllBranches();
    LoanBranchEntity getBranch(int id);
    String updateBranch(LoanBranchEntity entity);
    String deleteBranch(int id);
}
