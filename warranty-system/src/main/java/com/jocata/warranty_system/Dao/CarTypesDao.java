package com.jocata.warranty_system.Dao;

import com.jocata.warranty_system.entity.CarTypes;
import com.jocata.warranty_system.form.CarTypesResForm;

import java.util.List;

public interface CarTypesDao {

    CarTypes addCarType(CarTypes entity);
    CarTypes updatCarType(CarTypes entity);
    CarTypes getCarType(Integer id);
    List<CarTypes> getAllCarType();
    String deleteCarType(CarTypes entity);

}
