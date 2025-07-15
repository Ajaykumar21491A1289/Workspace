package com.jocata.los.userservice.service.impl;

import com.jocata.los.data.user.dao.UserDAO;
import com.jocata.los.datamodel.user.entity.User;
import com.jocata.los.datamodel.user.form.UserProfile;
import com.jocata.los.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;


    @Override
    public UserProfile saveUser(UserProfile userProfile) {
        return populateForm(dao.saveUser(populateEntity(userProfile)));
    }

    @Override
    public UserProfile getUserById(Long id) {
        return populateForm(dao.getUserById(id));
    }

    @Override
    public List<UserProfile> getAllUsers() {
        List<User> userList = dao.getAllUsers();
        List<UserProfile> forms= new ArrayList<>();
        for(User entity:userList){
            forms.add(populateForm(entity));
        }
        return forms;
    }

    @Override
    public UserProfile updateUser(Long id, UserProfile updatedUser) {
        User user = dao.getUserById(id);
        if(user!=null){
            User entity = populateEntity(updatedUser);
            entity.setId(user.getId());
            return populateForm(dao.updateUser(entity));
        }
            return null;
    }

    @Override
    public String deleteUser(Long id) {
        User user = dao.getUserById(id);
        if(user!=null) return dao.deleteUser(user);
        return "User Not Found In the DataBase";
    }


    private User populateEntity(UserProfile form){
        User entity = new User();
        entity.setUserName(form.getUserName());
        entity.setFullName(form.getFullName());
        entity.setEmail(form.getEmail());
        entity.setPhone(form.getPhone());
        entity.setAddress(form.getAddress());
        entity.setRole(form.getRole());
        return entity;
    }

    private UserProfile populateForm(User entity){
        UserProfile form = new UserProfile();
        form.setId(String.valueOf(entity.getId()));
        form.setUserName(entity.getUserName());
        form.setFullName(entity.getFullName());
        form.setEmail(entity.getFullName());
        form.setPhone(entity.getPhone());
        form.setAddress(entity.getAddress());
        form.setRole(entity.getRole());
        return form;
    }
}
