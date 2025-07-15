package com.jocata.warranty_system.service;

import com.jocata.warranty_system.form.CoverageTypeReqForm;
import com.jocata.warranty_system.form.CoverageTypeResForm;

import java.util.List;

public interface CoverageTypeService {
    CoverageTypeResForm addCoverareType(CoverageTypeReqForm form);
     CoverageTypeResForm updateCoverageType(CoverageTypeReqForm form);
    CoverageTypeResForm getCoverageTypes(String id);
    List<CoverageTypeResForm> getAllCoverageTypes();
    String deleteCoverageType(String id);
}
