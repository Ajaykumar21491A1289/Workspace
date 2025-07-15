package com.jocata.los.dao;

import com.jocata.los.entity.LoanApplications;

public interface LoanDetailsDao {

    LoanApplications addLoan(LoanApplications entity);
    LoanApplications getLoan(Integer loanId);
}
