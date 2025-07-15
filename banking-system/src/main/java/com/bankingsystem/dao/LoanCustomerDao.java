package com.bankingsystem.dao;

import com.bankingsystem.entity.LoanCustomerEntity;

import java.util.List;

public interface LoanCustomerDao {

    Integer addcustomer(LoanCustomerEntity entity);
    List<LoanCustomerEntity> getAllCustomers();
    LoanCustomerEntity getCustomer(Integer id);
    String updateCustomer(LoanCustomerEntity entity);
    String deleteCustomer(Integer id);

}
