package com.jocata.employee.service;

import com.jocata.employee.form.EmployeeForm;

public interface LoginService {
    public void addEmployee(EmployeeForm form);
    public String searchEmployee(String id, String userName);
    public String deleteEmployee(String id);
    public String updateEmployee(EmployeeForm form);
}
