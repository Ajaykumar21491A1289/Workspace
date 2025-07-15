package com.jocata.warranty_system.service;

import com.jocata.warranty_system.entity.Customers;
import com.jocata.warranty_system.form.CustomerReqForm;
import com.jocata.warranty_system.form.CustomerResForm;

import java.util.List;

public interface CustomerService {

    CustomerResForm createCustomer(CustomerReqForm form);
    CustomerResForm updateCustomer(CustomerReqForm form);
    CustomerResForm getCustomer(String id);
    List<CustomerResForm> getAllCustomer();
    String deleteCustomer(String id);
}
