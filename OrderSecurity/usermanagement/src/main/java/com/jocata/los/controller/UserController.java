package com.jocata.los.controller;

import com.jocata.los.service.UserService;
import com.jocata.los.user.entity.UserDetails;
import com.jocata.los.user.form.UserReqForm;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> createProfile(@RequestBody UserReqForm form){
        String res =userService.saveUser(form);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserReqForm form){
        return  userService.login(form);
    }
}
