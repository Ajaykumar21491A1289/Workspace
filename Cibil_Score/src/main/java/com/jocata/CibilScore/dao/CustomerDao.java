package com.jocata.CibilScore.dao;

import com.jocata.CibilScore.entity.Customer;

public interface CustomerDao {

    Customer saveCustomer(Customer customer);
    Customer findByPan(String pan);
}
