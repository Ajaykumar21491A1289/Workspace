package com.bankingsystem.service.imp;

import com.bankingsystem.dao.LoanBranchDao;
import com.bankingsystem.dao.imp.LoanBranchDaoImp;
import com.bankingsystem.entity.LoanBranchEntity;
import com.bankingsystem.form.LoanBranchForm;
import com.bankingsystem.service.LoanBranchService;

import java.util.ArrayList;
import java.util.List;

public class LoanBranchServiceImp implements LoanBranchService {

    private final LoanBranchDao dao = new LoanBranchDaoImp();

    @Override
    public String addBranch(LoanBranchForm form) {
        LoanBranchEntity entity = new LoanBranchEntity();
        entity.setName(form.getName());
        entity.setAddress(form.getAddress());
        entity.setState(form.getState());
        return dao.addBranch(entity);
    }

    @Override
    public List<LoanBranchForm> getAllBranches() {
        List<LoanBranchEntity> entities = dao.getAllBranches();
        List<LoanBranchForm> forms = new ArrayList<>();
        for (LoanBranchEntity entity : entities) {
            LoanBranchForm form = new LoanBranchForm();
            form.setBranchId(String.valueOf(entity.getBranchId()));
            form.setName(entity.getName());
            form.setAddress(entity.getAddress());
            form.setState(entity.getState());
            forms.add(form);
        }
        return forms;
    }

    @Override
    public LoanBranchForm getBranch(int id) {
        LoanBranchEntity entity = dao.getBranch(id);
        if (entity != null) {
            LoanBranchForm form = new LoanBranchForm();
            form.setBranchId(String.valueOf(entity.getBranchId()));
            form.setName(entity.getName());
            form.setAddress(entity.getAddress());
            form.setState(entity.getState());
            return form;
        }
        return null;
    }

    @Override
    public String updateBranch(LoanBranchForm form) {
        LoanBranchEntity entity = new LoanBranchEntity();
        entity.setBranchId(Integer.parseInt(form.getBranchId()));
        entity.setName(form.getName());
        entity.setAddress(form.getAddress());
        entity.setState(form.getState());
        return dao.updateBranch(entity);
    }

    @Override
    public String deleteBranch(int id) {
        return dao.deleteBranch(id);
    }
}
