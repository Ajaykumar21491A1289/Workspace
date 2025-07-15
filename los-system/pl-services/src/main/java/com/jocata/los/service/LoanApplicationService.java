package com.jocata.los.service;

import com.jocata.los.form.LoanDetailsForm;

public interface LoanApplicationService {
    LoanDetailsForm addLaonApplication(LoanDetailsForm form);
    LoanDetailsForm getLaonApplication(String loanId);
}
