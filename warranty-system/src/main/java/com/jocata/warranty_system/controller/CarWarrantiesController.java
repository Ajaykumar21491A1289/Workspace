package com.jocata.warranty_system.controller;

import com.jocata.warranty_system.form.CarWarrantiesReqForm;
import com.jocata.warranty_system.form.CarWarrantiesResForm;
import com.jocata.warranty_system.service.CarWarrantiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v8")
public class CarWarrantiesController {
    @Autowired
    CarWarrantiesService service;

    @PostMapping("/addCarWarranties")
    public CarWarrantiesResForm addCarWarranties(@RequestBody CarWarrantiesReqForm form){
        CarWarrantiesResForm res = null;
        try {
           if(form.getCarSaleId()!=null && !form.getCarSaleId().isEmpty() &&
           form.getPlanId()!=null && !form.getPlanId().isEmpty())
               res = service.addCarWarranties(form);
            if (res != null) {
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @GetMapping("/getCarWarranties")
    public List<CarWarrantiesResForm> getCarWarranties(@RequestParam String id){
        List<CarWarrantiesResForm> res = null;
        try {
            if(id!=null && !id.isEmpty())
                res = service.getCarWarranties(id);
            if (res != null) {
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
