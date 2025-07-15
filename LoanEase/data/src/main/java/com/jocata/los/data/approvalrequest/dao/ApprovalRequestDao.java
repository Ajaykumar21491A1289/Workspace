package com.jocata.los.data.approvalrequest.dao;

import com.jocata.los.datamodel.approval.entity.ApprovalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRequestDao extends JpaRepository<ApprovalRequest,Long> {

}
