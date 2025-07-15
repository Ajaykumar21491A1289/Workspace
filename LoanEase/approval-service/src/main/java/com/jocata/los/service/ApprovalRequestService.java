package com.jocata.los.service;

import com.jocata.los.datamodel.approval.form.ApprovalRequestForm;

public interface ApprovalRequestService {
    ApprovalRequestForm processApproval(ApprovalRequestForm form);
}
