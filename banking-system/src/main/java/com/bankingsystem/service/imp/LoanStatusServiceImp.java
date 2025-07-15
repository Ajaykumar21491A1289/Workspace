package com.bankingsystem.service.imp;

import com.bankingsystem.dao.LoanStatusDao;
import com.bankingsystem.dao.imp.LoanStatusDaoImp;
import com.bankingsystem.entity.LoanStatusEntity;
import com.bankingsystem.form.LoanStatusForm;
import com.bankingsystem.service.LoanStatusService;

import java.util.ArrayList;
import java.util.List;

public class LoanStatusServiceImp implements LoanStatusService {

    private  LoanStatusEntity entity = new LoanStatusEntity();
    private final LoanStatusDao dao = new LoanStatusDaoImp();


    @Override
    public String addlaonStatus(LoanStatusForm form) {
        entity.setStatusName(form.getStatusName());
        return dao.addLaonStatus(entity);
    }

    @Override
    public String updateLoanStatus(LoanStatusForm form) {
        entity.setStatusName(form.getStatusName());
        entity.setStatsId(Integer.parseInt(form.getStatsId()));
        return dao.updateLoanStatus(entity);
    }

    public List<LoanStatusForm> getAllLaonStatus() {
        List<LoanStatusForm> listForm = new ArrayList<>();
        entity = new LoanStatusEntity();
        List<LoanStatusEntity> listEntity = dao.getAllLoanStatus();
        for (LoanStatusEntity list : listEntity) {
            LoanStatusForm form = new LoanStatusForm();
            form.setStatusName(list.getStatusName());
            form.setStatsId(String.valueOf(list.getStatusId()));
            listForm.add(form);
        }
        return listForm;
    }

    public String getLoan(Integer id) {

        return dao.getLoan(id);
    }

    public String deleteLoan(Integer id) {

        return dao.deleteLoan(id);
    }
}
