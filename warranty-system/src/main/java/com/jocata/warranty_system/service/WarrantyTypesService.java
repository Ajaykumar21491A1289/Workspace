package com.jocata.warranty_system.service;

import com.jocata.warranty_system.form.WarrantyTypesReqForm;
import com.jocata.warranty_system.form.WarrantyTypesResForm;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface WarrantyTypesService {
    WarrantyTypesResForm addWarrantyType( WarrantyTypesReqForm form);
    WarrantyTypesResForm updateWarranty(WarrantyTypesReqForm form);
    WarrantyTypesResForm getWarrantyTypes(String id);
    List<WarrantyTypesResForm> getAllWarrantyTypes();
    String deleteWarrantyTypes(String id);
}
