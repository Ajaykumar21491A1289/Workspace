package com.jocata.los.service.impl;

import com.jocata.los.data.disbursment.dao.DisbursmentDao;
import com.jocata.los.datamodel.disbursment.entity.Disbursment;
import com.jocata.los.datamodel.disbursment.form.DisbursementForm;
import com.jocata.los.service.DisbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisbursementServiceImpl implements DisbursementService {

    @Autowired
    private DisbursmentDao disbursementRepository;

    @Override
    public DisbursementForm disburseLoan(DisbursementForm form) {
        double annualRate = calculateAnnualInterestRate();
        double monthlyRate = calculateMonthlyRate(annualRate);
        double emi = calculateEmi(form.getPrincipal(), monthlyRate, form.getMonths());

        Disbursment entity = convertFormToEntity(form, annualRate, emi);
        disbursementRepository.save(entity);

        return convertEntityToForm(entity);
    }

    private double calculateAnnualInterestRate() {
        return 10.0; // can be dynamic if needed later
    }

    private double calculateMonthlyRate(double annualRate) {
        return annualRate / 12 / 100;
    }

    private double calculateEmi(double principal, double monthlyRate, int months) {
        return (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);
    }

    private Disbursment convertFormToEntity(DisbursementForm form, double annualRate, double emi) {
        Disbursment disbursement = new Disbursment();
        disbursement.setLoanId(form.getLoanId());
        disbursement.setPrincipal(form.getPrincipal());
        disbursement.setMonths(form.getMonths());
        disbursement.setAnnualInterestRate(annualRate);
        disbursement.setMonthlyEmi(emi);
        return disbursement;
    }

    private DisbursementForm convertEntityToForm(Disbursment disbursement) {
        DisbursementForm form = new DisbursementForm();
        form.setLoanId(disbursement.getLoanId());
        form.setPrincipal(disbursement.getPrincipal());
        form.setMonths(disbursement.getMonths());
        form.setAnnualInterestRate(disbursement.getAnnualInterestRate());
        form.setMonthlyEmi(disbursement.getMonthlyEmi());
        return form;
    }
}