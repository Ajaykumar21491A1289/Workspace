package com.jocata.los.userservice.controller;

import com.jocata.los.datamodel.user.form.UserProfile;
import com.jocata.los.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public UserProfile createProfile(@RequestBody @Valid UserProfile userProfile){
        return service.saveUser(userProfile);
    };

    @GetMapping("/getUserById/{id}")
    public UserProfile getUserById(@PathVariable Long id){
        if(id!=null)  return service.getUserById(id);
        return null;
    }

    @GetMapping("/getAllUsers")
    public List<UserProfile> getAllUsers(){
        return service.getAllUsers();
    }

    @PutMapping("/updateUser/{id}")
    public UserProfile updateUser(@PathVariable Long id, @RequestBody @Valid UserProfile updatedUser){
        return service.updateUser(id,updatedUser);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        return service.deleteUser(id);
    }
}
