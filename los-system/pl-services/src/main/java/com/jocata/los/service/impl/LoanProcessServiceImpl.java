package com.jocata.los.service.impl;

import com.jocata.los.dao.LoanDetailsDao;
import com.jocata.los.entity.LoanApplications;
import com.jocata.los.service.LoanProcessService;
import com.jocata.los.util.LoanStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class LoanProcessServiceImpl implements LoanProcessService {

    @Autowired
    LoanDetailsDao loanDetailsDao;

    @Transactional
    @Override
    public String loanProcess(String requiredAmounts,String loanID) {

        LoanApplications entity = loanDetailsDao.getLoan(Integer.parseInt(loanID));
        if(entity!= null) {
            BigDecimal requiredAmount = new BigDecimal(requiredAmounts);
            BigDecimal approvedAmount = entity.getApprovedAmount();

            String creditStatus = entity.getCustomer().getCibilScoreDetails().getCreditStatus();
            BigDecimal interestRate = creditStatus.equalsIgnoreCase("good") ? new BigDecimal("10.5") : new BigDecimal("10.75");

            BigDecimal interest = requiredAmount.multiply(interestRate).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
            BigDecimal totalPayable = requiredAmount.add(interest);

            if (approvedAmount.compareTo(requiredAmount) >= 0) {
                entity.setStatus(LoanStatus.valueOf("approved"));
                entity.setApprovedAmount(totalPayable);
                loanDetailsDao.addLoan(entity);
                return "Loan Approved with Required: ₹" + requiredAmount +
                        ", Interest: ₹" + interest +
                        ", Total Payable: ₹" + totalPayable;
            } else {
                entity.setStatus(LoanStatus.valueOf("rejected"));
                entity.setApprovedAmount(requiredAmount);
                loanDetailsDao.addLoan(entity);
                return "Loan Rejected: Requested amount exceeds approved limit (Approved: ₹" + approvedAmount + ")";
            }
        }else{
            return "Loan not found for ID: " + loanID;
        }

    }
}
