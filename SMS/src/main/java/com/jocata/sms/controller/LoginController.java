package com.jocata.sms.controller;

import com.jocata.sms.service.LoginService;

public class LoginController {

    public String login(String userName, String password){

        System.out.println("In controller");
        if(userName!=null && !userName.isEmpty() && password!=null && !password.isEmpty()) {
            LoginService loginService = new LoginService();
            String validation = loginService.login(userName,password);
            return validation;
        }
        return "Fail";

    }


}
