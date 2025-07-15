package com.jocata.warranty_system.Dao;

import com.jocata.warranty_system.entity.WarrantyTypes;
import com.jocata.warranty_system.form.WarrantyTypesResForm;

import java.util.List;

public interface WarrantyTypesDao {

    WarrantyTypes addWarrantyType(WarrantyTypes entity);
    WarrantyTypes updateWarrantyTypes(WarrantyTypes entity);
    WarrantyTypes getWarrantyTypes(Integer id);
    List<WarrantyTypes> getAllWarrantyTypes();
    public String deleteWarrantyTypes(WarrantyTypes entity);
}
