package com.bankingsystem.service.imp;

import com.bankingsystem.dao.LoanCustomerDao;
import com.bankingsystem.dao.imp.LoanCustomerDaoImp;
import com.bankingsystem.entity.LoanCustomerEntity;
import com.bankingsystem.form.LoanCustomerForm;
import com.bankingsystem.service.LoanCustomerService;

import java.util.ArrayList;
import java.util.List;

public class LoanCustomerServiceImp implements LoanCustomerService {

    private final LoanCustomerDao dao = new LoanCustomerDaoImp();
    private LoanCustomerEntity entity = new LoanCustomerEntity();

    @Override
    public Integer addCustomer(LoanCustomerForm form) {
        entity.setName(form.getName());
        entity.setEmail(form.getEmail());
        entity.setPhone(form.getPhone());
        entity.setAddress(form.getAddress());
        entity.setDob(form.getDob());

        LoanCustomerDao dao = new LoanCustomerDaoImp();
        return dao.addcustomer(entity);
    }

    @Override
    public List<LoanCustomerForm> getAllCustomers() {
        List<LoanCustomerEntity> entities = dao.getAllCustomers();
        List<LoanCustomerForm> forms = new ArrayList<>();

        for (LoanCustomerEntity entity : entities) {
            LoanCustomerForm form = new LoanCustomerForm();
            form.setCustomerId(String.valueOf(entity.getCustomerId()));
            form.setName(entity.getName());
            form.setEmail(entity.getEmail());
            form.setPhone(entity.getPhone());
            form.setAddress(entity.getAddress());
            form.setDob(String.valueOf(entity.getDob()));

            forms.add(form);
        }

        return forms;
    }

    @Override
    public LoanCustomerForm getCustomer(Integer id) {
        entity = dao.getCustomer(id);

        if (entity != null) {
            LoanCustomerForm form = new LoanCustomerForm();
            form.setCustomerId(String.valueOf(entity.getCustomerId()));
            form.setName(entity.getName());
            form.setEmail(entity.getEmail());
            form.setPhone(entity.getPhone());
            form.setAddress(entity.getAddress());
            form.setDob(String.valueOf(entity.getDob()));
            return form;
        }

        return null;
    }

    @Override
    public String updateCustomer(LoanCustomerForm form) {
        entity.setCustomerId(Integer.parseInt(form.getCustomerId()));
        entity.setName(form.getName());
        entity.setEmail(form.getEmail());
        entity.setPhone(form.getPhone());
        entity.setAddress(form.getAddress());
        entity.setDob(form.getDob());
        return dao.updateCustomer(entity);
    }

    @Override
    public String deleteCustomer(Integer id) {
        LoanCustomerDao dao = new LoanCustomerDaoImp();
        return dao.deleteCustomer(id);
    }
}
