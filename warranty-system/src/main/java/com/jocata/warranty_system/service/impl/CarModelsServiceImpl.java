package com.jocata.warranty_system.service.impl;

import com.jocata.warranty_system.Dao.CarModelsDao;
import com.jocata.warranty_system.entity.CarModels;
import com.jocata.warranty_system.form.CarModelsReqForm;
import com.jocata.warranty_system.form.CarModelsResForm;
import com.jocata.warranty_system.service.CarModelsService;
import com.jocata.warranty_system.util.EngineType;
import com.jocata.warranty_system.util.FuelType;
import com.jocata.warranty_system.util.Transmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarModelsServiceImpl implements CarModelsService {

    @Autowired
    CarModelsDao dao;



    private CarModels formToEntity(CarModelsReqForm form){
        CarModels entity = new CarModels();
        entity.setMake(form.getMake());
        entity.setModelName(form.getModelName());
        entity.setYear(Integer.parseInt(form.getYear()));
        entity.setBasePrice(new BigDecimal(form.getBasePrice()));
        entity.setEngineType(EngineType.valueOf(form.getEngineType()));
        entity.setTransmission(Transmission.valueOf(form.getTransmission()));
        entity.setFuelType(FuelType.valueOf(form.getFuelType()));
        entity.setSeatingCapacity(Integer.valueOf(form.getSeatingCapacity()));
        entity.setWarrantyDurationMonths(Integer.valueOf(form.getWarrantyDurationMonths()));
        entity.setWarrantyKmLimit(Integer.valueOf(form.getWarrantyKmLimit()));
        return entity;
    }

    private CarModelsResForm entityToForm(CarModels entity){
        CarModelsResForm reqForm = new CarModelsResForm();
        reqForm.setId(String.valueOf(entity.getModelId()));
        reqForm.setMake(entity.getMake());
        reqForm.setModelName(entity.getModelName());
        reqForm.setYear(String.valueOf(entity.getYear()));
        reqForm.setBasePrice(String.valueOf(entity.getBasePrice()));
        reqForm.setEngineType(String.valueOf(entity.getEngineType()));
        reqForm.setTransmission(String.valueOf(entity.getTransmission()));
        reqForm.setFuelType(String.valueOf(entity.getFuelType()));
        reqForm.setSeatingCapacity(String.valueOf(entity.getSeatingCapacity()));
        reqForm.setWarrantyDurationMonths(String.valueOf(entity.getWarrantyDurationMonths()));
        reqForm.setWarrantyKmLimit(String.valueOf(entity.getWarrantyKmLimit()));
        reqForm.setCreatedAt(String.valueOf(entity.getCreatedAt()));
        return reqForm;
    }

    @Override
    public CarModelsResForm createCarModels(CarModelsReqForm form) {
        return entityToForm(dao.createCarModels(formToEntity(form)));
    }

    public CarModelsResForm updateCarModels(CarModelsReqForm form){
        CarModels model =dao.getCarModels(Integer.valueOf(form.getId()));
        if(model!=null) {
            CarModels entity = formToEntity(form);
            entity.setModelId(Integer.parseInt(form.getId()));
            return entityToForm(dao.updateCarModels(entity));
        }
        return null;
    }

    public CarModelsResForm getCarModels(String id){
        return entityToForm(dao.getCarModels(Integer.parseInt(id)));
    }
    public List<CarModelsResForm> getAllCarModels(){
        List<CarModels> carModelsList = dao.getAllCarModels();
        List<CarModelsResForm> forms = new ArrayList<>();
        for(CarModels model:carModelsList){
            forms.add(entityToForm(model));
        }
        return forms;
    }
    public String deleteCarModels(String id){
        return dao.deleteCarModels(dao.getCarModels(Integer.parseInt(id)));
    }
}
