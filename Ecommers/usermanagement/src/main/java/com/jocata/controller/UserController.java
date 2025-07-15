package com.jocata.controller;

import com.jocata.service.UserService;
import com.jocata.users.entity.Users;
import com.jocata.users.forms.UserForm;
import com.netflix.discovery.converters.Auto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public UserForm registerUser(@RequestBody @Valid UserForm form){
        return service.registerUser(form);

    }

    @PostMapping("/login/{userName}/{password}")
    public String loginUser(@PathVariable String userName , @PathVariable String password){
        return service.loginUser(userName,password);
    }

    @PutMapping("/update")
    public UserForm updateUser(@RequestBody @Valid UserForm form){
        return service.updateUser(form);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserForm> getUserById(@PathVariable Long id) {
        UserForm user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
