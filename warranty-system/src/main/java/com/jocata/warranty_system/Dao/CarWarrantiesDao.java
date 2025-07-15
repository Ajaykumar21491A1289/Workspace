package com.jocata.warranty_system.Dao;

import com.jocata.warranty_system.entity.CarWarranties;
import com.jocata.warranty_system.form.CarWarrantiesReqForm;
import com.jocata.warranty_system.form.CarWarrantiesResForm;

import java.util.List;

public interface CarWarrantiesDao {

    CarWarranties addCarWarranties(CarWarranties entity);
    List<CarWarranties> getCarWarranties(Integer carSaleId);
}
