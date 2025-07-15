package com.jocata.ordermanagement.customermanagement.service;

import com.jocata.ordermanagement.customermanagement.form.CustomerForm;

public interface CustomerService {

    String addCustomer(CustomerForm form);
    String updateCustomer(CustomerForm form);
    CustomerForm getCustomer(Integer customerId);
    public String deleteCustomer(Integer customerId);
}
