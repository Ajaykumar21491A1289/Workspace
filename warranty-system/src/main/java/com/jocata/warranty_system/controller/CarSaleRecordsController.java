package com.jocata.warranty_system.controller;

import com.jocata.warranty_system.form.CarSaleRecordsReqForm;
import com.jocata.warranty_system.form.CarSaleRecordsResForm;
import com.jocata.warranty_system.form.CarTypesResForm;
import com.jocata.warranty_system.service.CarSaleRecordsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v7")
public class CarSaleRecordsController {

    @Autowired
    CarSaleRecordsService service;

    @PostMapping("/AddCarSaleRecords")
    public CarSaleRecordsResForm addCarSaleRecords( @RequestBody CarSaleRecordsReqForm form){
        CarSaleRecordsResForm res=null;
        try{
            if(form.getCustomerId()!=null && !form.getCustomerId().isEmpty() &&
            form.getModelId()!=null && !form.getModelId().isEmpty() &&
            form.getCarTypeId()!=null && !form.getCarTypeId().isEmpty() &&
            form.getPurchaseDate()!=null && !form.getPurchaseDate().isEmpty())
                      res = service.addCarSaleRecords(form);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @PutMapping("/UpdateCarSaleRecords")
    public CarSaleRecordsResForm updateCarSaleRecords(@RequestBody CarSaleRecordsReqForm form){
        CarSaleRecordsResForm res=null;
        try{
            if(form.getId()!=null && !form.getId().isEmpty() &&
                    form.getCustomerId()!=null && !form.getCustomerId().isEmpty() &&
                    form.getModelId()!=null && !form.getModelId().isEmpty() &&
                    form.getCarTypeId()!=null && !form.getCarTypeId().isEmpty() &&
                    form.getPurchaseDate()!=null && !form.getPurchaseDate().isEmpty())
                         res = service.updateCarSaleRecords(form);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/GetCarSaleRecords")
    public CarSaleRecordsResForm getCarSaleRecords(@RequestParam String id){
        CarSaleRecordsResForm res=null;
        try{
            if(id!=null && !id.isEmpty())
                 res = service.getCarSaleRecords(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/GetAllCarSaleRecords")
    public List<CarSaleRecordsResForm> getAllCarSaleRecords(){
        List<CarSaleRecordsResForm> res=null;
        try{
            res = service.getAllCarSaleRecords();
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @DeleteMapping("/DeleteCarSaleRecords")
    public String deleteCarSaleRecords(String id){
        String res=null;
        try{
            if(id!=null && !id.isEmpty())
                 res = service.deleteCarSaleRecords(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
