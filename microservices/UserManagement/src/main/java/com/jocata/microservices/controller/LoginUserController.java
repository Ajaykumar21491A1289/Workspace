package com.jocata.microservices.controller;


import com.jocata.microservices.forms.UserReqForm;
import com.jocata.microservices.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginUserController {

    @Autowired
    LoginUserService service;

    @PostMapping("/user")
    public UserReqForm loginUser(@RequestBody UserReqForm form){

        return service.loginUser(form);

    }
}
