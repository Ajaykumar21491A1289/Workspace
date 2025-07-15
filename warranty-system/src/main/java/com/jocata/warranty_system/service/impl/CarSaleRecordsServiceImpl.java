package com.jocata.warranty_system.service.impl;

import com.jocata.warranty_system.Dao.CarModelsDao;
import com.jocata.warranty_system.Dao.CarSaleRecordsDao;
import com.jocata.warranty_system.Dao.CarTypesDao;
import com.jocata.warranty_system.Dao.CustomerDao;
import com.jocata.warranty_system.entity.CarSaleRecords;
import com.jocata.warranty_system.entity.Customers;
import com.jocata.warranty_system.form.CarSaleRecordsReqForm;
import com.jocata.warranty_system.form.CarSaleRecordsResForm;
import com.jocata.warranty_system.service.CarSaleRecordsService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarSaleRecordsServiceImpl implements CarSaleRecordsService {
    @Autowired
    CarSaleRecordsDao dao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    CarModelsDao carModelsDao;
    @Autowired
    CarTypesDao carTypesDao;



    private CarSaleRecordsResForm entityToForm(CarSaleRecords entity){
        CarSaleRecordsResForm form =new CarSaleRecordsResForm();
        form.setId(String.valueOf(entity.getCarSaleId()));
        form.setCustomerId(entity.getCustomerId().getName().toString());
        form.setModelId(entity.getModelId().getModelName().toString());
        form.setCarTypeId(entity.getCarTypeId().getCarTypeName().toString());
        form.setPurchaseDate(String.valueOf(entity.getPurchaseDate()));
        return form;

    }

    private CarSaleRecords formToEntity(CarSaleRecordsReqForm form){
        CarSaleRecords entity = new CarSaleRecords();
        entity.setCustomerId(customerDao.getCustomer(Integer.valueOf(form.getCustomerId())));
        entity.setModelId(carModelsDao.getCarModels(Integer.valueOf(form.getModelId())));
        entity.setCarTypeId(carTypesDao.getCarType(Integer.valueOf(form.getCarTypeId())));
        entity.setPurchaseDate(Date.valueOf(form.getPurchaseDate()));
        return entity;
    }
    @Override
    public CarSaleRecordsResForm addCarSaleRecords(CarSaleRecordsReqForm form) {
        Customers customer=customerDao.getCustomer(Integer.valueOf(form.getCustomerId()));
        if(customer!=null) {
            return entityToForm(dao.addCarSaleRecords(formToEntity(form)));
        }
        else{
            CarSaleRecordsResForm res = new CarSaleRecordsResForm();
            res.setMessage("Customer Not Found");
            return res;
        }
    }

    @Override
    public CarSaleRecordsResForm updateCarSaleRecords(CarSaleRecordsReqForm form) {
        CarSaleRecords res = dao.getCarSaleRecords(Integer.valueOf(form.getId()));
        if(res!=null) {
            CarSaleRecords entity = formToEntity(form);
            entity.setCarSaleId(Integer.valueOf(form.getId()));
            return entityToForm(dao.updateCarSaleRecords(entity));
        }
        return null;
    }

    @Override
    public CarSaleRecordsResForm getCarSaleRecords(String id) {
        return entityToForm(dao.getCarSaleRecords(Integer.parseInt(id)));
    }

    @Override
    public List<CarSaleRecordsResForm> getAllCarSaleRecords() {
        List<CarSaleRecordsResForm> forms = new ArrayList<>();
        List<CarSaleRecords> list = dao.getAllCarSaleRecords();
        for(CarSaleRecords entity:list){
            forms.add(entityToForm(entity));
        }
        return forms;
    }

    @Override
    public String deleteCarSaleRecords(String id) {
        CarSaleRecords entity = dao.getCarSaleRecords(Integer.parseInt(id));
        return dao.deleteCarSaleRecords(entity);
    }
}
