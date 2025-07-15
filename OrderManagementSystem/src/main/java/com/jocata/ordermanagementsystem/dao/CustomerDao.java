package com.jocata.ordermanagementsystem.dao;

import com.jocata.ordermanagementsystem.entity.CustomerEntity;
import com.jocata.ordermanagementsystem.form.CustomerForm;

import java.nio.file.Path;

public interface CustomerDao {

    public String addCustomer(CustomerEntity entity);
    public String updateCustomer(CustomerEntity entity);
    public CustomerEntity getCustomer(Integer customerId);
    public String deleteCustomer(Integer customerId);
}
