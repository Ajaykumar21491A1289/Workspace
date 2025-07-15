package com.jocata.oms.controller;

import com.jocata.oms.form.UserDetailsForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/user/create")
    public String createUser(@RequestBody UserDetailsForm user) {
        return user.getUsername() + "created successfully";
    }

    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "all users fetched successfully";
    }

    @GetMapping("/getUser/{userId}")
    public String getUser(@PathVariable Integer userId){
        return "Suresh";
    }
}
