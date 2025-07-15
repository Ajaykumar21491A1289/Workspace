package com.jocata.ordermanagement.customermanagement.dao;

import com.jocata.ordermanagement.customermanagement.entity.CustomerEntity;

public interface CustomerDao {

    public String addCustomer(CustomerEntity entity);
    public String updateCustomer(CustomerEntity entity);
    public CustomerEntity getCustomer(Integer customerId);
    public String deleteCustomer(Integer customerId);
}
