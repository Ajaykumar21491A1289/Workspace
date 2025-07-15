package com.jocata.microservices.service;

import com.jocata.microservices.forms.UserReqForm;

public interface RegisterUserService {

    UserReqForm registerUser(UserReqForm form);
}
