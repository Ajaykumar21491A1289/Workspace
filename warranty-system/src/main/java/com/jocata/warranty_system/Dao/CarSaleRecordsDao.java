package com.jocata.warranty_system.Dao;

import com.jocata.warranty_system.entity.CarSaleRecords;
import com.jocata.warranty_system.form.CarSaleRecordsReqForm;
import com.jocata.warranty_system.form.CarSaleRecordsResForm;

import java.util.List;

public interface CarSaleRecordsDao {

    CarSaleRecords addCarSaleRecords(CarSaleRecords entity);
    CarSaleRecords updateCarSaleRecords(CarSaleRecords entity);
    CarSaleRecords getCarSaleRecords(Integer id);
    List<CarSaleRecords> getAllCarSaleRecords();
    String deleteCarSaleRecords(CarSaleRecords entity);
}
