package com.jocata.los;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return "User registered successfully!";
    }

    @GetMapping("/getUserDetails")
    public String getByUsername(@RequestParam String username) {
        return username;
    }

}
