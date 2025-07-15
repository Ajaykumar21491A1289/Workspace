package com.bankingsystem.controller;

import com.bankingsystem.form.LoanTypeForm;
import com.bankingsystem.service.LoanTypeService;
import com.bankingsystem.service.imp.LoanTypeServiceImp;

import java.util.List;

public class LoanTypeController {

    private final LoanTypeService service = new LoanTypeServiceImp();

    public String addLoanType(LoanTypeForm form) {
        if (form.getLoanType() != null && !form.getLoanType().isEmpty() &&
                form.getIntrestRate() != null && !form.getIntrestRate().isEmpty()) {
            return service.addLoanType(form);

        }
        return " Failed to add Record";
    }

    public String updateLoanType(LoanTypeForm form) {
        if (form.getLoanTypeId() != null && !form.getLoanTypeId().isEmpty() &&
                form.getLoanType() != null && !form.getLoanType().isEmpty() &&
                form.getIntrestRate() != null && !form.getIntrestRate().isEmpty()) {
            return service.updateLoanType(form);

        }

        return " Record Not Found";
    }

    public List<LoanTypeForm> getAllLaonTypes() {
        return service.getAllLaonTypes();
    }

    public void getLoanType(Integer id) {
        LoanTypeForm form = service.getLoanType(id);
        if (form != null) {
            System.out.println("Loan Type ID: " + form.getLoanTypeId());
            System.out.println("Loan Type: " + form.getLoanType());
            System.out.println("Interest Rate: " + form.getIntrestRate());
        } else {
            System.out.println("No loan type found with ID: " + id);
        }
    }


    public String deleteLaonType(Integer id) {
        return service.deleteLaonType(id);

    }
}
