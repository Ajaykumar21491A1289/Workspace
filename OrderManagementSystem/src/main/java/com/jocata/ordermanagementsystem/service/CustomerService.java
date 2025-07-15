package com.jocata.ordermanagementsystem.service;

import com.jocata.ordermanagementsystem.form.CustomerForm;

import java.nio.file.Path;

public interface CustomerService {
    String addCustomer(CustomerForm form);
    String updateCustomer(CustomerForm form);
    CustomerForm getCustomer(Integer customerId);
    public String deleteCustomer(Integer customerId);
}
