package com.jocata.ordermanagementsystem.service.imp;

import com.jocata.ordermanagementsystem.dao.CustomerDao;
import com.jocata.ordermanagementsystem.dao.imp.CustomerDaoImp;
import com.jocata.ordermanagementsystem.entity.CustomerEntity;
import com.jocata.ordermanagementsystem.form.CustomerForm;
import com.jocata.ordermanagementsystem.service.CustomerService;

import java.nio.file.Path;

public class CustomerServiceImp implements CustomerService {
    CustomerDao dao = new CustomerDaoImp();
    CustomerEntity entity = new CustomerEntity();

    public CustomerEntity addDetails(CustomerForm form){
        entity.setCustomerId(Integer.parseInt(form.getCustomerId()));
        entity.setName(form.getName());
        entity.setEmail(form.getEmail());
        entity.setAddress(form.getAddress());
        return entity;

    }

    public String addCustomer(CustomerForm form){
        return dao.addCustomer(addDetails(form));

    }

    public String updateCustomer(CustomerForm form){
        return dao.updateCustomer(addDetails(form));
    }

    public CustomerForm getCustomer(Integer customerId){
        CustomerForm form = new CustomerForm();
        CustomerEntity entity = dao.getCustomer(customerId);
        form.setCustomerId(entity.getCustomerId().toString());
        form.setName(entity.getName());
        form.setEmail(entity.getEmail());
        form.setText(entity.getAddress());
        return form;
    }
    public String deleteCustomer(Integer customerId){
        return dao.deleteCustomer(customerId);
    }
}
