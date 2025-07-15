package com.jocata.los.service.impl;

import com.jocata.los.config.JwtUtil;
import com.jocata.los.service.UserService;
import com.jocata.los.user.entity.UserDetails;
import com.jocata.los.user.form.UserReqForm;
import com.jocata.los.userdao.UserDao;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String saveUser(UserReqForm form) {

        if(userDao.getUserByUsername(form.getName())!=null){
            return "User Already Exist";
        }
        UserDetails user = new UserDetails();
        user.setUsername(form.getName());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setRole(form.getRole());
        userDao.save(user);
        return "User Created Successfully";
    }

    @Override
    public String login(UserReqForm form) {
        String role=null;
        UserDetails userDetails = userDao.getUserByUsername(form.getName());

        if(userDetails!=null){
            boolean isMatch = passwordEncoder.matches(form.getPassword(),userDetails.getPassword());
            if(isMatch) role = userDetails.getRole();
        }

        if(role !=null){
            String token= JwtUtil.generateToken(form.getName(),role);
            return token;
        }
        return null;
    }
}
