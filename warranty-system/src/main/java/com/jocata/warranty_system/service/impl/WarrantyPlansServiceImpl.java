package com.jocata.warranty_system.service.impl;

import com.jocata.warranty_system.Dao.CoverageTypeDao;
import com.jocata.warranty_system.Dao.WarrantyPlansDao;
import com.jocata.warranty_system.Dao.WarrantyTypesDao;
import com.jocata.warranty_system.entity.CoverageTypes;
import com.jocata.warranty_system.entity.WarrantyPlans;
import com.jocata.warranty_system.entity.WarrantyTypes;
import com.jocata.warranty_system.form.WarrantyPlansReqForm;
import com.jocata.warranty_system.form.WarrantyPlansResForm;
import com.jocata.warranty_system.form.WarrantyTypesResForm;
import com.jocata.warranty_system.service.WarrantyPlansService;
import com.jocata.warranty_system.util.CoverageType;
import com.jocata.warranty_system.util.WarrantyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class WarrantyPlansServiceImpl implements WarrantyPlansService {

    @Autowired
    WarrantyPlansDao dao;
    @Autowired
    WarrantyTypesDao warrantyTypeDao;
    @Autowired
    CoverageTypeDao coverageTypeDao;


    private WarrantyPlans formToEntity(WarrantyPlansReqForm form){
        WarrantyPlans entity = new WarrantyPlans();
        entity.setName(form.getName());
        entity.setDurationMonths(Integer.valueOf(form.getDurationMonths()));
        entity.setKmLimit(Integer.valueOf(form.getKmLimit()));
        WarrantyTypes warrantyTypeEntity = warrantyTypeDao.getWarrantyTypes(Integer.parseInt(form.getWarrantyType()));
        CoverageTypes coverageTypeEntity = coverageTypeDao.getCoverageTypes(Integer.parseInt(form.getCoverageType()));

        entity.setWarrantyType(warrantyTypeEntity);
        entity.setCoverageType(coverageTypeEntity);
        entity.setBasePrice(new BigDecimal(form.getBasePrice()));
        entity.setSurchargePercent(new BigDecimal(form.getSurchargePercent()));
        return entity;
    }

    private WarrantyPlansResForm entityToForm(WarrantyPlans entity){
        WarrantyPlansResForm form  = new WarrantyPlansResForm();
        form.setPlanId(String.valueOf(entity.getPlanId()));
        form.setName(entity.getName());
        form.setDurationMonths(String.valueOf(entity.getDurationMonths()));
        form.setKmLimit(String.valueOf(entity.getKmLimit()));
        String warrantyTypeName = entity.getWarrantyType().getName().toString();  // assuming enum or String
        String coverageTypeName = entity.getCoverageType().getCoverageTypeId().toString();
        form.setWarrantyType(warrantyTypeName);
        form.setCoverageType(coverageTypeName);
        form.setBasePrice(String.valueOf(entity.getBasePrice()));
        form.setSurchargePercent(String.valueOf(entity.getSurchargePercent()));
        return form;
    }

    @Override
    public WarrantyPlansResForm addWarrantyPlan(WarrantyPlansReqForm form) {
        return entityToForm(dao.addWarrantyPlans(formToEntity(form)));
    }

    public WarrantyPlansResForm updateWarrantyPlan(WarrantyPlansReqForm form){
        WarrantyPlans res = dao.getWarrantyPlans(Integer.valueOf(form.getPlanId()));
        if(res!=null) {
            WarrantyPlans entity = formToEntity(form);
            entity.setPlanId(Integer.parseInt(form.getPlanId()));
            return entityToForm(dao.updateWarrantyPlans(entity));
        }
        return null;

    }

    @Override
    public WarrantyPlansResForm getWarrantyPlan(String id) {
        return entityToForm(dao.getWarrantyPlans(Integer.parseInt(id)));
    }

    @Override
    public List<WarrantyPlansResForm> getAllWarrantyPlan() {
        List<WarrantyPlansResForm> forms = new ArrayList<>();
        List<WarrantyPlans> entityList = dao.getALlWarrantyPlans();
        for(WarrantyPlans entity : entityList){
            forms.add(entityToForm(entity));
        }
        return forms;
    }

    @Override
    public String deleteWarrantyPlan(String id) {
        return dao.deleteWarrantyPlans(dao.getWarrantyPlans(Integer.parseInt(id)));
    }
}
