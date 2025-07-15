package com.jocata.ordermanagement.customermanagement.controller;

import com.jocata.ordermanagement.customermanagement.form.CustomerForm;
import com.jocata.ordermanagement.customermanagement.service.CustomerService;
import com.jocata.ordermanagement.customermanagement.service.impl.CustomerServiceImpl;

public class CustomerController {

    CustomerService service = new CustomerServiceImpl();

    public String addCustomer(CustomerForm form) {
        if (form.getCustomerId() != null && !form.getCustomerId().isEmpty() &&
                form.getName() != null && !form.getName().isEmpty() &&
                form.getEmail() != null && !form.getEmail().isEmpty() &&
                form.getAddress() != null && !form.getAddress().isEmpty()) {
            return service.addCustomer(form);
        }

        return " Validation Not Satisfied";

    }

    public String updateCustomer(CustomerForm form) {
        if (form.getCustomerId() != null && !form.getCustomerId().isEmpty() &&
                form.getName() != null && !form.getName().isEmpty() &&
                form.getEmail() != null && !form.getEmail().isEmpty() &&
                form.getAddress() != null && !form.getAddress().isEmpty()) {
            return service.updateCustomer(form);
        }
        return " Validation Not Satisfied";
    }

    public CustomerForm getCustomer(Integer customerId) {
        if (customerId != null) {
            return service.getCustomer(customerId);
        }
        return null;
    }


    public String deleteCustomer(Integer customerId){
        if(customerId!=null){
            return  service.deleteCustomer(customerId);
        }
        return " Validation Not Satisfied";
    }

}
