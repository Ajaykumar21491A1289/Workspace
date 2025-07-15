package com.jocata.warranty_system.service;

import com.jocata.warranty_system.form.CarSaleRecordsReqForm;
import com.jocata.warranty_system.form.CarSaleRecordsResForm;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CarSaleRecordsService {
    CarSaleRecordsResForm addCarSaleRecords(CarSaleRecordsReqForm form);
    public CarSaleRecordsResForm updateCarSaleRecords(CarSaleRecordsReqForm form);
    CarSaleRecordsResForm getCarSaleRecords(String id);
    List<CarSaleRecordsResForm> getAllCarSaleRecords();
    String deleteCarSaleRecords(String id);
}
