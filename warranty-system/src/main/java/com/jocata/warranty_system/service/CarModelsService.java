package com.jocata.warranty_system.service;

import com.jocata.warranty_system.form.CarModelsReqForm;
import com.jocata.warranty_system.form.CarModelsResForm;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CarModelsService {

    CarModelsResForm createCarModels(CarModelsReqForm form);
    CarModelsResForm updateCarModels(CarModelsReqForm form);
    CarModelsResForm getCarModels(String id);
    List<CarModelsResForm> getAllCarModels();
    String deleteCarModels(String id);
}
