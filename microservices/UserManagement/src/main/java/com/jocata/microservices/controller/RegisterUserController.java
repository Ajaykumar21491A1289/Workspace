package com.jocata.microservices.controller;

import com.jocata.microservices.entity.UserRoles;
import com.jocata.microservices.entity.Users;
import com.jocata.microservices.forms.UserReqForm;
import com.jocata.microservices.service.RegisterUserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    RegisterUserService service;

    @PostMapping("/user")
    public UserReqForm registerUser(@RequestBody UserReqForm form){
        return service.registerUser(form);
    }
}
