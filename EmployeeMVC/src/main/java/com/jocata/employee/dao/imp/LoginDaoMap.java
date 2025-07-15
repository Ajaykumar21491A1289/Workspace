/*
package com.jocata.employee.dao.imp;

import com.jocata.employee.dao.LoginDao;
import com.jocata.employee.entity.EmployeeEntity;
import com.jocata.employee.form.EmployeeForm;

import java.util.*;

public class LoginDaoMap {

    Map<Integer,EmployeeEntity> map = new HashMap<Integer,EmployeeEntity>();

    public void addEmployee(EmployeeEntity entity){
        map.put(entity.getId(),entity);
    }

    public String searchEmployee(String id){
        if(map.containsKey(id)){
            return "Employee Found";
        }
        return "Employee Not Found";
    }

    public String deleteEmployee(Integer id){
        if(map.containsKey(id)){
            map.remove(id);
            return "Employee Deleted Successfully";
        }
        return "EMployee Not Found";

    }
    public String updateEmployee(EmployeeEntity entity) {
        if(map.containsKey(entity.getId())){
            map.put(entity.getId(),entity);
            return "Employee Updated Successfully";
        }
        return "Employee Not Found";
    }
}
*/