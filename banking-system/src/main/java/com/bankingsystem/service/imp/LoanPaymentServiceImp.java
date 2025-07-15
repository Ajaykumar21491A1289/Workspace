package com.bankingsystem.service.imp;

import com.bankingsystem.dao.LoanDao;
import com.bankingsystem.dao.LoanPaymentDao;
import com.bankingsystem.dao.imp.LoanDaoImp;
import com.bankingsystem.dao.imp.LoanPaymentDaoImp;
import com.bankingsystem.entity.LoanPaymentEntity;
import com.bankingsystem.entity.LoanResponseEntity;
import com.bankingsystem.form.LoanPaymentForm;
import com.bankingsystem.service.LoanPaymentService;
import com.bankingsystem.util.EmiCalculated;
import com.bankingsystem.util.EmiDetails;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class LoanPaymentServiceImp implements LoanPaymentService {

    LoanPaymentDao paymentDao = new LoanPaymentDaoImp();

    public String addLaonPayment(LoanPaymentForm form) {
        LoanDao dao = new LoanDaoImp();
        LoanPaymentEntity entity = new LoanPaymentEntity();
        entity.setLoanID(form.getLoanID());

        LoanResponseEntity loan = dao.getLoan(entity.getLoanID());
        List<EmiDetails> list = EmiCalculated.calculateEmi(
                loan.getPrincipalAmount(),
                loan.getIntrestRate(),
                loan.getTermMonths()
        );

        int paymentCount = paymentDao.getPaymentCountForLoan(entity.getLoanID());

        if (paymentCount < list.size()) {
            EmiDetails emiDetails = list.get(paymentCount);

            float interestComponent = emiDetails.getInterestComponent();
            float principalComponent = emiDetails.getPrincipalComponent();
            float amountPaid = principalComponent + interestComponent;

            entity.setPrincipalComponent(String.valueOf(principalComponent));
            entity.setIntrestComponent(String.valueOf(interestComponent));
            entity.setAmountPaid(String.valueOf(amountPaid));

        } else {
            return "Thankyou you have Paid all EMI Dues";
        }

        return paymentDao.addLaonPayment(entity);
    }


    public String updateLoanPayment(LoanPaymentForm form) {
        LoanPaymentEntity entity = new LoanPaymentEntity();
        entity.setLoanID(form.getLoanID());
        entity.setPaymentId(form.getPaymentId());
        entity.setPaymentDate(form.getPaymentDate());
        entity.setAmountPaid(form.getAmountPaid());
        entity.setPrincipalComponent(form.getPrincipalComponent());
        entity.setIntrestComponent(form.getIntrestComponent());
        return paymentDao.updateLoanPayment(entity);


    }

    public File getLaonPayment(String loanId) {

        return paymentDao.getLaonPayment(Integer.parseInt(loanId));

    }

    public Path getAllLaonPayment() {
        return paymentDao.getAllLaonPayment();


    }

    public String deleteLaon(String loanId) {
        return paymentDao.deleteLaon(Integer.parseInt(loanId));

    }
}
