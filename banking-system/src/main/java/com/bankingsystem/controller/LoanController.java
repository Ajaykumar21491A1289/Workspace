package com.bankingsystem.controller;

import com.bankingsystem.form.LoanForm;
import com.bankingsystem.service.LoanService;
import com.bankingsystem.service.imp.LoanServiceImp;

public class LoanController {

    private final LoanService service = new LoanServiceImp();

    public void addLoan(LoanForm form){
        if( form.getLoanTypeId()!=null && form.getBranchId()!=null && form.getStatusId()!=null && form.getPrincipalAmount()!=null && form.getTermMonths()!=null ){
           System.out.println(service.addLoan(form));
        }

    }
    public void getAllLoans(){
        service.getAllLoans();
    }

    public void getLoan(Integer loanId){
        if(loanId!=null)  service.getLoan(loanId);
        else System.out.println("LoanID is Null");
    }

    public void updateLaon(LoanForm form){
        if(form.getLoanId()!=null && form.getStatusId()!=null) service.updateLoan(form);
        else System.out.println("Enter Proper Details");
    }

    public void deleteLoan(Integer id){
        if(id!=null) service.deleteLoan(id);
        else System.out.println("Enter Correct Loan Id");
    }

    public String approveLoan(Integer loanID){
       if(loanID!=null) return service.approveLoan(loanID);
       return "Status Not Changed";
    }
}
