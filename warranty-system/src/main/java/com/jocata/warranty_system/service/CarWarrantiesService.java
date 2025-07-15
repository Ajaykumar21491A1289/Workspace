package com.jocata.warranty_system.service;

import com.jocata.warranty_system.form.CarWarrantiesReqForm;
import com.jocata.warranty_system.form.CarWarrantiesResForm;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CarWarrantiesService {
    CarWarrantiesResForm addCarWarranties(CarWarrantiesReqForm form);
    List<CarWarrantiesResForm> getCarWarranties(String id);
}
