package com.jocata.los.service;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendLoanApprovalEmail(Long loanId, String remarks){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("malineniajaykumar@gmail.com");
        message.setSubject("Loan Approved"+ loanId);
        message.setText("Your loan #" + loanId + " is approved.\nRemarks: " + remarks);
        mailSender.send(message);
    }
}
