package com.bankingsystem.controller;

import com.bankingsystem.form.LoanBranchForm;
import com.bankingsystem.service.LoanBranchService;
import com.bankingsystem.service.imp.LoanBranchServiceImp;

import java.util.List;

public class LoanBranchController {

    private final LoanBranchService service = new LoanBranchServiceImp();

    public String addBranch(LoanBranchForm form) {
        if (form.getName() != null && !form.getName().isEmpty() &&
                form.getAddress() != null && !form.getAddress().isEmpty() &&
                form.getCity() != null && !form.getCity().isEmpty() &&
                form.getState() != null && !form.getState().isEmpty()) {
            return service.addBranch(form);
        }
        return "Failed to Add Branch Validation Not Satisfied";
    }

    public void getAllBranches() {
        List<LoanBranchForm> branches = service.getAllBranches();
        for (LoanBranchForm form : branches) {
            System.out.println(form.getBranchId() + " " + form.getName() + " " + form.getAddress() + " " + form.getCity() + " " + form.getState());
        }
    }

    public void getBranch(int id) {
        LoanBranchForm form = service.getBranch(id);
        if (form != null) {
            System.out.println(form.getBranchId() + " " + form.getName() + " " + form.getAddress() + " " + form.getCity() + " " + form.getState());
        } else {
            System.out.println("Branch not found.");
        }
    }

    public String updateBranch(LoanBranchForm form) {
        if (form.getBranchId() != null && !form.getBranchId().isEmpty() &&
                form.getName() != null && !form.getName().isEmpty() &&
                form.getAddress() != null && !form.getAddress().isEmpty() &&
                form.getCity() != null && !form.getCity().isEmpty() &&
                form.getState() != null && !form.getState().isEmpty()) {
            return service.updateBranch(form);
        }
        return "Failed to Add Branch Validation Not Satisfied";
    }

    public String deleteBranch(int id) {
        return service.deleteBranch(id);
    }
}
