package com.jocata.oms.controller;

import com.jocata.oms.servivce.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/email/send")
    public String sendMail(@RequestParam String to) {
        emailService.sendEmail(to, "Test Subject", "Hello, this is a test email.");
        return "Email Sent!";
    }
}

