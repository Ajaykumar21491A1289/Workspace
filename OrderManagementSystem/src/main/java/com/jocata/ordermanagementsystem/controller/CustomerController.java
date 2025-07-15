package com.jocata.ordermanagementsystem.controller;

import com.jocata.ordermanagementsystem.form.CustomerForm;
import com.jocata.ordermanagementsystem.service.CustomerService;
import com.jocata.ordermanagementsystem.service.imp.CustomerServiceImp;

import java.nio.file.Path;

public class CustomerController {

    CustomerService service = new CustomerServiceImp();

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
