package com.jocata.sms.main;

import com.jocata.sms.controller.LoginController;

public class LoginMain {
    public static void main(String[] args){

        LoginController loginController = new LoginController();
        System.out.println(loginController.login("AJAY","AJ"));
    }
}
