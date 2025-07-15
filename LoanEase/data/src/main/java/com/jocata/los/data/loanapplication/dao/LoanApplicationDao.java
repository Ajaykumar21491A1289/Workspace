package com.jocata.los.data.loanapplication.dao;

import com.jocata.los.datamodel.loanapplication.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationDao  {

    LoanApplication saveApplication(LoanApplication application);
}
