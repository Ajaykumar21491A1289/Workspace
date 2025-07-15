package com.jocata.microservices.service.impl;

import com.jocata.microservices.dao.UserRoleDao;
import com.jocata.microservices.dao.UsersDao;
import com.jocata.microservices.entity.UserRoles;
import com.jocata.microservices.entity.Users;
import com.jocata.microservices.forms.UserReqForm;
import com.jocata.microservices.service.RegisterUserService;
import com.jocata.microservices.util.Roles;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    UsersDao usersDao;

    @Autowired
    UserRoleDao userRoleDao;


    @Transactional
    @Override
    public UserReqForm registerUser(UserReqForm form) {
        Users user = new Users();
        user.setUserName(form.getUserName());
        user.setPassword(form.getPassword());
        Users res =usersDao.registerUser(user);

        UserRoles roles = new UserRoles();
        roles.setUsers(res);
        roles.setRole(Roles.valueOf(form.getRole()));
        userRoleDao.addUserRole(roles);

        form.setId(String.valueOf(res.getId()));
        form.setMessage("User Registered Successfully");
        return form;
    }
}
