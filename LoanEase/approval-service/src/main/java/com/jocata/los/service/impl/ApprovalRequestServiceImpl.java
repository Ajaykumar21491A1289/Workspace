package com.jocata.los.service.impl;

import com.jocata.los.data.approvalrequest.dao.ApprovalRequestDao;
import com.jocata.los.datamodel.approval.entity.ApprovalRequest;
import com.jocata.los.datamodel.approval.form.ApprovalRequestForm;
import com.jocata.los.datamodel.approval.form.LoanApprovedEvent;
import com.jocata.los.service.ApprovalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    @Autowired
    private ApprovalRequestDao approvalRequestRepository;

    @Autowired
    private KafkaTemplate<String, LoanApprovedEvent> kafkaTemplate;

    @Override
    public ApprovalRequestForm processApproval(ApprovalRequestForm form) {
        ApprovalRequest entity = convertFormToEntity(form);
        ApprovalRequest saved = approvalRequestRepository.save(entity);
        populateKafka(saved);
        return convertEntityToForm(saved);
    }

    private void populateKafka(ApprovalRequest saved) {

        LoanApprovedEvent event = new LoanApprovedEvent();
        event.setLoanId(saved.getLoanId());
        event.setStatus(saved.getStatus());
        event.setRemarks("Loan approved with status: " + saved.getStatus());
        kafkaTemplate.send("loan-approvals",event);
    }

    private ApprovalRequest convertFormToEntity(ApprovalRequestForm form) {
        ApprovalRequest entity = new ApprovalRequest();
        entity.setLoanId(form.getLoanId());
        entity.setStatus(form.getStatus());
        entity.setRemarks(form.getRemarks());
        return entity;
    }

    private ApprovalRequestForm convertEntityToForm(ApprovalRequest entity) {
        ApprovalRequestForm form = new ApprovalRequestForm();
        form.setLoanId(entity.getLoanId());
        form.setStatus(entity.getStatus());
        form.setRemarks(entity.getRemarks() + " | Loan Approved Successfully");
        return form;
    }
}
