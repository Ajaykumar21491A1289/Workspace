package com.bankingsystem.service;

import com.bankingsystem.form.LoanBranchForm;

import java.util.List;

public interface LoanBranchService {
    String addBranch(LoanBranchForm form);
    List<LoanBranchForm> getAllBranches();
    LoanBranchForm getBranch(int id);
    String updateBranch(LoanBranchForm form);
    String deleteBranch(int id);
}
