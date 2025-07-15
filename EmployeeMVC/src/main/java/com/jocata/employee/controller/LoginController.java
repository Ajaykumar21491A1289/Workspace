package com.jocata.employee.controller;

import com.jocata.employee.form.EmployeeForm;
import com.jocata.employee.service.LoginService;
import com.jocata.employee.service.impl.LoginServiceImpl;

import java.util.Objects;

public class LoginController {

    LoginService service = new LoginServiceImpl();

    public void addEmployee(EmployeeForm form) {
        if (form.getDataOfJoin() != null && !form.getDataOfJoin().isEmpty() &&
                form.getDesignation() != null && !form.getDesignation().isEmpty() &&
                form.getId() != null && !form.getId().isEmpty() &&
                form.getSalary() != null && !form.getSalary().isEmpty() &&
                form.getUserName() != null && !form.getUserName().isEmpty() &&
                form.getDateOfBirth() != null && !form.getDateOfBirth().isEmpty()) {

            service.addEmployee(form);
        }

    }

    public String searchEmployee(String id, String userName) {
        if (!id.isEmpty()) {
            return service.searchEmployee(id, userName);
        }
        return "Emmployee Not Found";
    }

    public String deleteEmployee(String id) {
        if (!id.isEmpty()) {
            return service.deleteEmployee(id);
        }
        return "Emmployee Not Found";
    }

    public String updateEmployee(EmployeeForm form) {
        if (!form.getDataOfJoin().isEmpty() &&
                !form.getDesignation().isEmpty() &&
                !form.getId().isEmpty() &&
                !form.getSalary().isEmpty() &&
                !form.getUserName().isEmpty() &&
                !form.getDateOfBirth().isEmpty()) {
            return service.updateEmployee(form);
        }
        return "Employee Not Found";
    }

    public static void closeController() {
        LoginServiceImpl.closeService();
    }


}
