package com.jocata.warranty_system.Dao;

import com.jocata.warranty_system.entity.Customers;
import com.jocata.warranty_system.form.CustomerResForm;

import java.util.List;

public interface CustomerDao {

    Customers createCustomer(Customers entity);
    Customers updateCustomer(Customers entity);
    Customers getCustomer(Integer id);
    List<Customers> getAllCustomer();
    String deleteCustomer(Customers entity);
}
