package com.jocata.los.service;

import org.springframework.web.bind.annotation.RequestParam;

public interface LoanProcessService {
    String loanProcess(String requiredAmount,String loanId);
}
