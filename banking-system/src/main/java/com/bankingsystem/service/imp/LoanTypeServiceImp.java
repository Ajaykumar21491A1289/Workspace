package com.bankingsystem.service.imp;

import com.bankingsystem.dao.LoanTypeDao;
import com.bankingsystem.dao.imp.LoanTypeDaoImp;
import com.bankingsystem.entity.LoanTypeEntity;
import com.bankingsystem.form.LoanTypeForm;
import com.bankingsystem.service.LoanTypeService;

import java.util.*;

public class LoanTypeServiceImp implements LoanTypeService {

    private final LoanTypeEntity entity = new LoanTypeEntity();
    private final LoanTypeDao dao = new LoanTypeDaoImp();

    public String addLoanType(LoanTypeForm form) {
        entity.setLoanType(form.getLoanType());
        entity.setIntrestRate(Float.valueOf(form.getIntrestRate()));
        return dao.addLoanType(entity);

    }

    public String updateLoanType(LoanTypeForm form) {
        entity.setLoanTypeId(Integer.valueOf(form.getLoanTypeId()));
        entity.setLoanType(form.getLoanType());
        entity.setIntrestRate(Float.valueOf(form.getIntrestRate()));
        return dao.updateLoanType(entity);
    }

    public List<LoanTypeForm> getAllLaonTypes() {

        List<LoanTypeForm> forms = new ArrayList<>();
        List<LoanTypeEntity> entities = dao.getAllLaonTypes();
        for (LoanTypeEntity loanEntity : entities) {
            LoanTypeForm form = new LoanTypeForm();
            form.setLoanTypeId(String.valueOf(loanEntity.getLoanTypeId()));
            form.setLoanType(loanEntity.getLoanType());
            form.setIntrestRate(String.valueOf(loanEntity.getIntrestRate()));
            forms.add(form);
        }
        return forms;
    }

    public LoanTypeForm getLoanType(Integer id) {
        LoanTypeEntity entity = dao.getLoanType(id);
        if (entity == null) {
            return null; // or throw an exception if preferred
        }

        LoanTypeForm form = new LoanTypeForm();
        form.setLoanTypeId(String.valueOf(entity.getLoanTypeId()));
        form.setLoanType(entity.getLoanType());
        form.setIntrestRate(String.valueOf(entity.getIntrestRate()));
        return form;
    }


    public String deleteLaonType(Integer id) {

        return dao.deleteLaonType(id);

    }
}
