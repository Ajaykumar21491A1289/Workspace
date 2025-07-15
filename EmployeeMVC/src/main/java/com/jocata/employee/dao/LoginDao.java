package com.jocata.employee.dao;

import com.jocata.employee.entity.EmployeeEntity;
import com.jocata.employee.form.EmployeeForm;

public interface LoginDao {

    public void addEmployee(EmployeeEntity entity) ;
    public String searchEmployee(String id);

    public String deleteEmployee(String id);
    public String updateEmployee(EmployeeEntity Entity);
}
