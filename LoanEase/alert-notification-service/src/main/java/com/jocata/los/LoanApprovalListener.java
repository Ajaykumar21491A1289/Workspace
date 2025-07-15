package com.jocata.los;

import com.jocata.los.datamodel.approval.form.LoanApprovedEvent;
import com.jocata.los.service.EmailService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class LoanApprovalListener {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics ="loan-approvals",groupId = "notification-group",containerFactory = "kafkaListenerContainerFactory")
    public void consumeLoanApproval(LoanApprovedEvent event){
        System.out.println("Received loan approval event: "+ event.getLoanId());
        emailService.sendLoanApprovalEmail(event.getLoanId(), event.getRemarks());
    }
}
