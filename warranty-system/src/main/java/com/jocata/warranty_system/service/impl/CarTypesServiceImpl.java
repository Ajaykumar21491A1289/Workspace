package com.jocata.warranty_system.service.impl;

import com.jocata.warranty_system.Dao.CarTypesDao;
import com.jocata.warranty_system.entity.CarTypes;
import com.jocata.warranty_system.form.CarModelsResForm;
import com.jocata.warranty_system.form.CarTypesReqForm;
import com.jocata.warranty_system.form.CarTypesResForm;
import com.jocata.warranty_system.service.CarTypesService;
import com.jocata.warranty_system.util.CarType;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarTypesServiceImpl implements CarTypesService {

    @Autowired
    CarTypesDao dao;


    private CarTypes formToEntity(CarTypesReqForm form){
        CarTypes entity = new CarTypes();
        entity.setCarTypeName(CarType.fromString(form.getName()));
        return entity;
    }
    private CarTypesResForm entityToForm(CarTypes entity){
        CarTypesResForm form = new CarTypesResForm();
        form.setId(String.valueOf(entity.getCarTypeId()));
        form.setName(String.valueOf(entity.getCarTypeName()));
        return form;
    }
    @Override
    public CarTypesResForm addCarType(CarTypesReqForm form) {
        return entityToForm(dao.addCarType(formToEntity(form)));
    }

    @Override
    public CarTypesResForm updateCarType(CarTypesReqForm form) {
        CarTypes res = dao.getCarType(Integer.valueOf(form.getId()));
        if(res!=null) {
            CarTypes entity = formToEntity(form);
            entity.setCarTypeId(Integer.valueOf(form.getId()));
            return entityToForm(dao.updatCarType(entity));
        }
        return null;
    }

    @Override
    public CarTypesResForm getCarType(String id) {
        return entityToForm(dao.getCarType(Integer.parseInt(id)));
    }

    @Override
    public List<CarTypesResForm> getAllCarTypes() {
        List<CarTypesResForm> forms = new ArrayList<>();
        List<CarTypes> list = dao.getAllCarType();
        for(CarTypes entity:list){
            forms.add(entityToForm(entity));
        }
        return forms;
    }

    @Override
    public String deleteCarType(String id) {
        return dao.deleteCarType(dao.getCarType(Integer.valueOf(id)));
    }
}
