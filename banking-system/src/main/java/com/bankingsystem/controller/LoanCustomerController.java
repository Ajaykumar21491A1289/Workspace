package com.bankingsystem.controller;

import com.bankingsystem.form.LoanCustomerForm;
import com.bankingsystem.service.LoanCustomerService;
import com.bankingsystem.service.imp.LoanCustomerServiceImp;

import java.util.List;

public class LoanCustomerController {

    private final LoanCustomerService service = new LoanCustomerServiceImp();

    public Integer addCustomer(LoanCustomerForm form) {
        if (form.getName() != null && !form.getName().isEmpty() &&
                form.getEmail() != null && !form.getEmail().isEmpty() &&
                form.getPhone() != null && !form.getPhone().isEmpty() &&
                form.getAddress() != null && !form.getAddress().isEmpty() &&
                form.getDob() != null && !form.getDob().isEmpty()) {

            return service.addCustomer(form);
        }
        return 0;
    }

    public void getAllCustomers() {

        List<LoanCustomerForm> customers = service.getAllCustomers();
        for (LoanCustomerForm form : customers) {
            System.out.println(form.getCustomerId() + " " + form.getName() + " " + form.getEmail() + " " + form.getPhone() + " " + form.getAddress() + " " + form.getDob());
        }
    }

    public void getCustomer(int id) {
        LoanCustomerForm form = service.getCustomer(id);
        if (form != null) {
            System.out.println(form.getCustomerId() + " " + form.getName() + " " + form.getEmail() + " " + form.getPhone() + " " + form.getAddress() + " " + form.getDob());
        } else {
            System.out.println("Not a Valid ID");
        }

    }

    public String updateCustomer(LoanCustomerForm form) {
        if (form.getCustomerId() != null && !form.getCustomerId().isEmpty() &&
                form.getName() != null && !form.getName().isEmpty() &&
                form.getEmail() != null && !form.getEmail().isEmpty() &&
                form.getPhone() != null && !form.getPhone().isEmpty() &&
                form.getAddress() != null && !form.getAddress().isEmpty() &&
                form.getDob() != null && !form.getDob().isEmpty()) {
            return service.updateCustomer(form);
        }
        return "Customer not updated Validation not Satisfied";
    }

    public String deleteCustomer(int id) {
        if (id > 0) {
            return service.deleteCustomer(id);
        }
        return "Record Not Deleted.";
    }
}
