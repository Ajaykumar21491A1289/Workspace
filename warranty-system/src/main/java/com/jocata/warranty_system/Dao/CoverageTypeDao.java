package com.jocata.warranty_system.Dao;

import com.jocata.warranty_system.entity.CoverageTypes;


import java.util.List;

public interface CoverageTypeDao {
    CoverageTypes addCoverareType(CoverageTypes entity);
    CoverageTypes updateCoverageType(CoverageTypes form);
    CoverageTypes getCoverageTypes(Integer id);
    List<CoverageTypes> getAllCoverageTypes();
    String deleteCoverageType(CoverageTypes entity);
}
