package com.jocata.oms.controller;

import com.jocata.oms.form.UserDetailsForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class LoginController {

    final static Map<String, UserDetailsForm> data = new HashMap<String, UserDetailsForm>();

    static {
        UserDetailsForm user = new UserDetailsForm();
        user.setUsername("suresh.sanem@gmail.com");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        data.put(user.getUsername(), user);
        user = new UserDetailsForm();
        user.setUsername("su.san@gmail.com");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        user.setRoles(Arrays.asList("USER"));
        data.put(user.getUsername(), user);
    }

    @RequestMapping("/user")
    public UserDetailsForm findByUsername(@RequestParam String username) {
        return data.get(username);
    }

}
