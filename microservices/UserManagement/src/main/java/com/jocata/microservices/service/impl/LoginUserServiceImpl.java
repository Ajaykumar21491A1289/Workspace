package com.jocata.microservices.service.impl;

import com.jocata.microservices.dao.UsersDao;
import com.jocata.microservices.employee.Employeer;
import com.jocata.microservices.entity.Users;
import com.jocata.microservices.forms.UserReqForm;
import com.jocata.microservices.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    UsersDao usersDao;

    @Autowired
    Employeer employeer;


    @Override
    public UserReqForm loginUser(UserReqForm form) {
        Users entity = usersDao.findByUsername(form.getUserName());
        String password= entity.getPassword();
        if(password.equals(form.getPassword())){
            form.setMessage("Login in SuccessFull as "+entity.getUserRoles().getRole()+"  "+employeer.getEmployee());
        }
        else{
            form.setMessage("Login Failed as "+entity.getUserRoles().getRole());
        }
        form.setId(String.valueOf(entity.getId()));
        form.setRole(String.valueOf(entity.getUserRoles().getRole()));
        return form;
    }
}
