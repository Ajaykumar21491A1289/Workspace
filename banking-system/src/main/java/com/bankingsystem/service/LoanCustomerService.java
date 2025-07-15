package com.bankingsystem.service;

import com.bankingsystem.form.LoanCustomerForm;

import java.util.List;

public interface LoanCustomerService {

    Integer addCustomer(LoanCustomerForm form);
    List<LoanCustomerForm> getAllCustomers();
    LoanCustomerForm getCustomer(Integer id);
    String updateCustomer(LoanCustomerForm form);
    String deleteCustomer(Integer id);
}
