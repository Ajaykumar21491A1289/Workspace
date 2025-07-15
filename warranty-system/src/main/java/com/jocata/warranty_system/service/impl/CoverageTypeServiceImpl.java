package com.jocata.warranty_system.service.impl;

import com.jocata.warranty_system.Dao.CoverageTypeDao;
import com.jocata.warranty_system.entity.CoverageTypes;
import com.jocata.warranty_system.form.CoverageTypeReqForm;
import com.jocata.warranty_system.form.CoverageTypeResForm;
import com.jocata.warranty_system.service.CoverageTypeService;
import com.jocata.warranty_system.util.CoverageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoverageTypeServiceImpl implements CoverageTypeService {

    @Autowired
    CoverageTypeDao dao;

    private CoverageTypes formToEntity(CoverageTypeReqForm form){
        CoverageTypes entity = new CoverageTypes();
        entity.setName(CoverageType.valueOf(form.getName()));
        return entity;
    }

    private CoverageTypeResForm entityToForm(CoverageTypes entity){
        CoverageTypeResForm form = new CoverageTypeResForm();
        form.setId(String.valueOf(entity.getCoverageTypeId()));
        form.setName(String.valueOf(entity.getName()));
        return form;
    }
    @Override
    public CoverageTypeResForm addCoverareType(CoverageTypeReqForm form) {
        return entityToForm(dao.addCoverareType(formToEntity(form)));
    }

    @Override
    public CoverageTypeResForm updateCoverageType(CoverageTypeReqForm form) {
        CoverageTypes entity = formToEntity(form);
        entity.setCoverageTypeId(Integer.valueOf(form.getId()));
        return entityToForm(dao.updateCoverageType(entity));

    }

    @Override
    public CoverageTypeResForm getCoverageTypes(String id) {
        return entityToForm(dao.getCoverageTypes(Integer.parseInt(id)));
    }

    @Override
    public List<CoverageTypeResForm> getAllCoverageTypes() {
        List<CoverageTypeResForm> resForms = new ArrayList<>();
        List<CoverageTypes> entityList = dao.getAllCoverageTypes();
        for(CoverageTypes entity:entityList){
            resForms.add(entityToForm(entity));
        }
        return resForms;
    }

    @Override
    public String deleteCoverageType(String id) {
        CoverageTypes entity =dao.getCoverageTypes(Integer.parseInt(id));
        if(entity!=null){
            return dao.deleteCoverageType(entity);
        }
        return "Entity Not Found";
    }
}
