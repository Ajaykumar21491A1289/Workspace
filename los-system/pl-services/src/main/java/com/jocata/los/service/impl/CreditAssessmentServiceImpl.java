package com.jocata.los.service.impl;

import com.jocata.los.dao.LoanDetailsDao;
import com.jocata.los.entity.Customers;
import com.jocata.los.entity.LoanApplications;
import com.jocata.los.entity.CibilScoreDetails;
import com.jocata.los.entity.IncomeDetails;
import com.jocata.los.service.CreditAssessmentService;
import com.jocata.los.util.LoanStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class CreditAssessmentServiceImpl implements CreditAssessmentService {

    @Autowired
    LoanDetailsDao loanDetailsDao;

    @Override
    @Transactional
    public String creditAssessment(String loanId) {
        LoanApplications loan = loanDetailsDao.getLoan(Integer.parseInt(loanId));
        Customers customer = loan.getCustomer();
        CibilScoreDetails cibil = customer.getCibilScoreDetails();
        IncomeDetails incomeDetails = customer.getIncomeDetails();

        String creditStatus = cibil.getCreditStatus();
        Integer activeLoans = cibil.getNoOfActiveAccounts();
        Integer enquiryCount = cibil.getNoOfEnquiry();
        Integer tenureMonths = loan.getLoanTenureMonths();
        BigDecimal requestedAmount = loan.getLoanAmount();
        BigDecimal income = incomeDetails.getMonthlyIncome();
        BigDecimal totalEmis = cibil.getEmisTotal();

        if (creditStatus.equalsIgnoreCase("good") || creditStatus.equalsIgnoreCase("average")) {
            if (activeLoans < 5 && enquiryCount < 5) {
                BigDecimal available = income.subtract(totalEmis);
                if (available.compareTo(BigDecimal.ZERO) > 0) {
                    BigDecimal sanctionAmount = available.multiply(BigDecimal.valueOf(tenureMonths));

                    BigDecimal interestRate;
                    if (creditStatus.equalsIgnoreCase("good")) {
                        interestRate = new BigDecimal("10.5");
                    } else {
                        interestRate = new BigDecimal("10.75");
                    }

                    BigDecimal timeInYears = BigDecimal.valueOf(tenureMonths).divide(BigDecimal.valueOf(12), 2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal interest = sanctionAmount.multiply(interestRate).multiply(timeInYears).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal totalPayable = sanctionAmount.add(interest);

                    loan.setApprovedAmount(totalPayable);
                    loan.setStatus(LoanStatus.in_process);
                    loanDetailsDao.addLoan(loan);

                    return "Loan Approved with sanction amount ₹" + sanctionAmount +
                            ", interest ₹" + interest +
                            ", total payable ₹" + totalPayable;
                } else {
                    loan.setStatus(LoanStatus.valueOf("rejected"));
                    loanDetailsDao.addLoan(loan);
                    return "Loan Rejected: No disposable income";
                }
            } else {
                loan.setStatus(LoanStatus.valueOf("rejected"));
                loanDetailsDao.addLoan(loan);
                return "Loan Rejected: Too many active loans or enquiries";
            }
        } else {
            loan.setStatus(LoanStatus.valueOf("rejected"));
            loanDetailsDao.addLoan(loan);
            return "Loan Rejected: Poor credit score";
        }
    }
}
