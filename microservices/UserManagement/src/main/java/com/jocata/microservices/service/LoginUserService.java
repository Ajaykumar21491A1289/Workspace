package com.jocata.microservices.service;

import com.jocata.microservices.forms.UserReqForm;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginUserService {

    UserReqForm loginUser(UserReqForm form);
}
