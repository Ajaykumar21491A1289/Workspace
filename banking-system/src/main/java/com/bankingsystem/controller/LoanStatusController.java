package com.bankingsystem.controller;

import com.bankingsystem.form.LoanStatusForm;
import com.bankingsystem.service.LoanStatusService;
import com.bankingsystem.service.imp.LoanStatusServiceImp;

import java.util.List;

public class LoanStatusController {

    private final LoanStatusService loanStatusService = new LoanStatusServiceImp();

    public String addLoanStatus(LoanStatusForm form) {
        if (form.getStatusName() != null && !form.getStatusName().isEmpty()) {
            return loanStatusService.addlaonStatus(form);
        }
        return "Status Not Added";
    }

    public String updateLoanStatus(LoanStatusForm form) {

        if (form.getStatusName() != null && !form.getStatusName().isEmpty() && form.getStatsId() != null && !form.getStatsId().isEmpty()) {
            return loanStatusService.updateLoanStatus(form);
        }
        return "Status Not Found TO Update";
    }

    public void getAllLaonStatus() {

        List<LoanStatusForm> form = loanStatusService.getAllLaonStatus();
        for (LoanStatusForm listForm : form) {
            System.out.println(listForm.getStatsId() + " " + listForm.getStatusName());
        }
    }

    public void getLoan(Integer id) {
        if (id != null) {

            System.out.println(loanStatusService.getLoan(id));
        }

    }

    public void deleteLoan(Integer id) {

        if (id != null) {

            System.out.println(loanStatusService.deleteLoan(id));
        }
    }

}

