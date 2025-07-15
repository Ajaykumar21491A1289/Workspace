package com.jocata.sms.service;

import com.jocata.sms.dao.LoginDao;

public class LoginService {

    public String login(String userName,String password){
        System.out.println("In Service");
        LoginDao loginDao = new LoginDao();
       String pswd= loginDao.login(userName);
       if(password.equals(pswd)){
         return "Success";
       }
      return "Fail";
    }
}
