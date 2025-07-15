package com.jocata.warranty_system.service;

import com.jocata.warranty_system.form.WarrantyPlansReqForm;
import com.jocata.warranty_system.form.WarrantyPlansResForm;
import com.jocata.warranty_system.form.WarrantyTypesResForm;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface WarrantyPlansService {
    WarrantyPlansResForm addWarrantyPlan(WarrantyPlansReqForm form);
    WarrantyPlansResForm updateWarrantyPlan(WarrantyPlansReqForm form);
    WarrantyPlansResForm getWarrantyPlan(String id);
    List<WarrantyPlansResForm> getAllWarrantyPlan();
    String deleteWarrantyPlan(String id);
}
