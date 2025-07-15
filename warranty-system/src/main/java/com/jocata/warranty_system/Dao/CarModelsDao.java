package com.jocata.warranty_system.Dao;

import com.jocata.warranty_system.entity.CarModels;
import com.jocata.warranty_system.form.CarModelsReqForm;
import com.jocata.warranty_system.form.CarModelsResForm;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CarModelsDao {
    CarModels createCarModels(CarModels entity);
    CarModels updateCarModels(CarModels entity);
    CarModels getCarModels(Integer id);
    List<CarModels> getAllCarModels();
    String deleteCarModels(CarModels entity);
}
