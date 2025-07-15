package com.jocata.los.service;

import com.jocata.los.EmiCalculator;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LoanDisbursmentService {
    List<EmiCalculator.EmiMonth> loanDisbursment(String loanId);
}
