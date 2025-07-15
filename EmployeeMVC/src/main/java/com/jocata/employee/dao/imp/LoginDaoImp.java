
package com.jocata.employee.dao.imp;


import com.jocata.employee.dao.LoginDao;
import com.jocata.employee.entity.EmployeeEntity;
import com.jocata.employee.form.EmployeeForm;

import java.sql.*;
import java.util.*;

public class LoginDaoImp implements LoginDao {

        List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();

    public void addEmployee(EmployeeEntity entity){
        list.add(entity);
    }

    public String searchEmployee(String id){
        Iterator<EmployeeEntity> iterator =list.iterator();
        while (iterator.hasNext()) {
            EmployeeEntity entity = iterator.next();
            if (id.equals(entity.getId())) {
            return "found";
            }
        }

        return "null";
    }

    public String deleteEmployee(String id){

        Iterator<EmployeeEntity> iterator =list.iterator();
        while(iterator.hasNext()){
            EmployeeEntity entity = iterator.next();
            if(entity.getId().equals(id)){
                iterator.remove();
                return "Employee Deleted";
            }
        }
        return "Employee Not Found";

    }
    public String updateEmployee(EmployeeEntity Entity) {

        Iterator<EmployeeEntity> iterator =list.iterator();
        while (iterator.hasNext()) {
            EmployeeEntity entity = iterator.next();
            if (entity.getId().equals(Entity.getId())) {

                if (entity.getId().equals(Entity.getId()) && entity.getUserName().equals(Entity.getUserName()) && entity.getDesignation().equals(Entity.getDesignation()) & entity.getSalary().equals(Entity.getSalary()) && entity.getDateOfJoin().equals(Entity.getDateOfJoin()) && entity.getDateOfBirth().equals(Entity.getDateOfBirth())) {
                    return "Employee Updated";
                }
                list.remove(entity);
                return "Employee Updated";
            } else addEmployee(Entity);
        }
        return "Employee Not Found";
    }

    }





