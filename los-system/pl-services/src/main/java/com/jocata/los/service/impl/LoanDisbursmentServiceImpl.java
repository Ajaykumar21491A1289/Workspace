package com.jocata.los.service.impl;

import com.jocata.los.EmiCalculator;
import com.jocata.los.dao.LoanDetailsDao;
import com.jocata.los.entity.LoanApplications;
import com.jocata.los.service.LoanDisbursmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LoanDisbursmentServiceImpl implements LoanDisbursmentService {

    @Autowired
    LoanDetailsDao loanDetailsDao;

    @Override
    public List<EmiCalculator.EmiMonth> loanDisbursment(String loanId) {
        LoanApplications loan = loanDetailsDao.getLoan(Integer.parseInt(loanId));

        BigDecimal principal = loan.getApprovedAmount();
        int tenureMonths = loan.getLoanTenureMonths();
        String creditStatus = loan.getCustomer().getCibilScoreDetails().getCreditStatus();

        BigDecimal annualInterestRate = creditStatus.equalsIgnoreCase("good")
                ? new BigDecimal("10.5")
                : new BigDecimal("10.75");

        return EmiCalculator.generateSchedule(principal, annualInterestRate, tenureMonths);
    }
}
