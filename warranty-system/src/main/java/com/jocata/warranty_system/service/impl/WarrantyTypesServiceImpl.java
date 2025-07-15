package com.jocata.warranty_system.service.impl;

import com.jocata.warranty_system.Dao.WarrantyTypesDao;
import com.jocata.warranty_system.entity.CarWarranties;
import com.jocata.warranty_system.entity.WarrantyTypes;
import com.jocata.warranty_system.form.WarrantyTypesReqForm;
import com.jocata.warranty_system.form.WarrantyTypesResForm;
import com.jocata.warranty_system.service.WarrantyTypesService;
import com.jocata.warranty_system.util.WarrantyType;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarrantyTypesServiceImpl implements WarrantyTypesService {
    @Autowired
    WarrantyTypesDao dao;

    private WarrantyTypes formToEntity(WarrantyTypesReqForm form){
        WarrantyTypes type = new WarrantyTypes();
        type.setName(WarrantyType.valueOf(form.getName()));
        return type;
    }

    private WarrantyTypesResForm entityToForm(WarrantyTypes entity){
        WarrantyTypesResForm resForm = new WarrantyTypesResForm();
        resForm.setId(String.valueOf(entity.getWarrantyTypeId()));
        resForm.setName(String.valueOf(entity.getName()));
        return resForm;
    }

    public WarrantyTypesResForm addWarrantyType(WarrantyTypesReqForm form){
        return entityToForm(dao.addWarrantyType(formToEntity(form)));
    }

    public WarrantyTypesResForm updateWarranty(WarrantyTypesReqForm form){
        WarrantyTypes res=dao.getWarrantyTypes(Integer.parseInt(form.getId()));
        if(res!=null) {
            WarrantyTypes entity = formToEntity(form);
            entity.setWarrantyTypeId(Integer.valueOf(form.getId()));
            return entityToForm(dao.updateWarrantyTypes(entity));
        }
        return null;

    }

    @Override
    public WarrantyTypesResForm getWarrantyTypes(String id) {
        return entityToForm(dao.getWarrantyTypes(Integer.parseInt(id)));
    }

    @Override
    public List<WarrantyTypesResForm> getAllWarrantyTypes() {
        List<WarrantyTypesResForm> forms = new ArrayList<>();
        List<WarrantyTypes> warrantyTypesList = dao.getAllWarrantyTypes();
        for(WarrantyTypes entity:warrantyTypesList){
            forms.add(entityToForm(entity));
        }
        return forms;
    }

    @Override
    public String deleteWarrantyTypes(String id) {
        WarrantyTypes entity = dao.getWarrantyTypes(Integer.parseInt(id));
        if(entity!=null){
            return dao.deleteWarrantyTypes(entity);
        }
        return "Row Id Not Found";
    }


}
