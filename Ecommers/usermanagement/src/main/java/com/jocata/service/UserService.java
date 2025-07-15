package com.jocata.service;

import com.jocata.users.entity.Users;
import com.jocata.users.forms.UserForm;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {

    UserForm registerUser(UserForm form);
    String loginUser(String userName , String password);
    UserForm updateUser(UserForm form);
    UserForm getUserById(Long id);
}
