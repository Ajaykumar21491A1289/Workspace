package com.jocata.warranty_system.service.impl;

import com.jocata.warranty_system.Dao.CustomerDao;
import com.jocata.warranty_system.entity.Customers;
import com.jocata.warranty_system.form.CustomerReqForm;
import com.jocata.warranty_system.form.CustomerResForm;
import com.jocata.warranty_system.service.CustomerService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao dao;



    private Customers formToEntity(CustomerReqForm form){
        Customers customer = new Customers();
        customer.setName(form.getName());
        customer.setEmail(form.getEmail());
        customer.setPhone(form.getPhone());
        customer.setAddress(form.getAddress());
        return customer;
    }


    private CustomerResForm entityToForm(Customers entity){
        CustomerResForm reqForm = new CustomerResForm(); // Initialize here
        reqForm.setId(String.valueOf(entity.getCustomerId()));
        reqForm.setName(entity.getName());
        reqForm.setEmail(entity.getEmail());
        reqForm.setPhone(entity.getPhone());
        reqForm.setAddress(entity.getAddress());
        reqForm.setTimeStamp(String.valueOf(entity.getCreatedAt()));
        return reqForm;
    }

    @Override
    public CustomerResForm createCustomer(CustomerReqForm form) {
       return  entityToForm(dao.createCustomer(formToEntity(form)));

    }

    @Override
    public CustomerResForm updateCustomer(CustomerReqForm form) {
        Customers customers = dao.getCustomer(Integer.parseInt(form.getId()));
        if(customers!=null) {
            Customers entity = formToEntity(form);
            entity.setCustomerId(Integer.valueOf(form.getId()));
            return entityToForm(dao.updateCustomer(entity));
        }
        return null;
    }

    public CustomerResForm getCustomer(String id){
        return entityToForm(dao.getCustomer(Integer.parseInt(id)));

    }
    public List<CustomerResForm> getAllCustomer(){
        List<Customers> lists = dao.getAllCustomer();
        List<CustomerResForm> forms=new ArrayList<>();
        for(Customers list:lists){
            forms.add(entityToForm(list));
        }
        return forms;
    }


    public String deleteCustomer(String id){
        Customers customer = dao.getCustomer(Integer.parseInt(id));
        if(customer!=null){
            return dao.deleteCustomer(customer);
        }
        return "No Customer Found";
    }
}
