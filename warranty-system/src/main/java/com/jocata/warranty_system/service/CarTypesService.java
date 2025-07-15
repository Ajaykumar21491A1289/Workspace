package com.jocata.warranty_system.service;

import com.jocata.warranty_system.form.CarModelsResForm;
import com.jocata.warranty_system.form.CarTypesReqForm;
import com.jocata.warranty_system.form.CarTypesResForm;

import java.util.List;

public interface CarTypesService {
    CarTypesResForm addCarType(CarTypesReqForm form);
    CarTypesResForm updateCarType(CarTypesReqForm form);
    CarTypesResForm getCarType(String id);
    List<CarTypesResForm> getAllCarTypes();
    String deleteCarType(String id);
}
