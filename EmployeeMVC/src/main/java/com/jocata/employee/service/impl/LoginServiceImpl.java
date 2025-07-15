package com.jocata.employee.service.impl;

import com.jocata.employee.dao.LoginDao;
//import com.jocata.employee.dao.imp.LoginDaoImp;
import com.jocata.employee.dao.imp.LoginDaoJdbc;
import com.jocata.employee.entity.EmployeeEntity;
import com.jocata.employee.form.EmployeeForm;
import com.jocata.employee.service.LoginService;

public class LoginServiceImpl implements LoginService {

    //LoginDao loginDao = new LoginDaoImp();
    LoginDaoJdbc loginDao = new LoginDaoJdbc();
    EmployeeEntity entity = new EmployeeEntity();

    public EmployeeEntity addDetails(EmployeeForm form) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setDateOfJoin(form.getDataOfJoin());
        entity.setDesignation(form.getDesignation());
        entity.setId(form.getId());
        entity.setSalary(form.getSalary());
        entity.setUserName(form.getUserName());
        entity.setDateOfBirth(form.getDateOfBirth());
        return entity;
    }

    public void addEmployee(EmployeeForm form) {
        addDetails(form);
        loginDao.addEmployee(entity);
    }

    public String searchEmployee(String id, String userName) {

        String value = loginDao.searchEmployee(id);
        // if(value.equals("found")) return "Employee Found";
        if (value.equals(userName)) return "Employee Found";
        return "Employee Not Found";
    }

    public String deleteEmployee(String id) {

         return loginDao.deleteEmployee(id);


    }

    public String updateEmployee(EmployeeForm form) {
        addDetails(form);
        return loginDao.updateEmployee(entity);

    }

    public static void closeService() {
        LoginDaoJdbc.closeConnection();
    }
}
