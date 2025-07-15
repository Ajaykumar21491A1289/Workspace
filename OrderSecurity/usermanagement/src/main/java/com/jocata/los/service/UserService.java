package com.jocata.los.service;

import com.jocata.los.user.form.UserReqForm;
import org.springframework.http.ResponseEntity;

public interface UserService {

    String saveUser(UserReqForm form);

    String login(UserReqForm form);
}
