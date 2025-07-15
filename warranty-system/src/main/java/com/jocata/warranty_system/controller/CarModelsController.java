package com.jocata.warranty_system.controller;

import com.jocata.warranty_system.form.CarModelsReqForm;
import com.jocata.warranty_system.form.CarModelsResForm;
import com.jocata.warranty_system.service.CarModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2")
public class CarModelsController {

    @Autowired
    private CarModelsService service;

    @PostMapping("/CreateCarModels")
    public CarModelsResForm createCarModels( @RequestBody  CarModelsReqForm form){
        CarModelsResForm res=null;
        try{
            if(form.getMake()!=null && !form.getMake().isEmpty() &&
            form.getModelName()!=null && !form.getModelName().isEmpty()&&
            form.getYear()!=null && !form.getYear().isEmpty() &&
            form.getBasePrice()!=null && !form.getBasePrice().isEmpty() &&
            form.getEngineType()!=null && !form.getEngineType().isEmpty() &&
            form.getTransmission()!=null && !form.getTransmission().isEmpty() &&
            form.getFuelType()!=null && !form.getFuelType().isEmpty() &&
            form.getSeatingCapacity()!=null && !form.getSeatingCapacity().isEmpty()&&
            form.getWarrantyDurationMonths()!=null && !form.getWarrantyDurationMonths().isEmpty() &&
            form.getWarrantyKmLimit()!=null && !form.getWarrantyKmLimit().isEmpty()) {
                res = service.createCarModels(form);
            }
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @PutMapping("/UpdateCarModels")
    public CarModelsResForm updateCarModels(@RequestBody  CarModelsReqForm form){
        CarModelsResForm res=null;
        try{
            if(form.getId()!=null && !form.getId().isEmpty() &&
                    form.getMake()!=null && !form.getMake().isEmpty() &&
                    form.getModelName()!=null && !form.getModelName().isEmpty()&&
                    form.getYear()!=null && !form.getYear().isEmpty() &&
                    form.getBasePrice()!=null && !form.getBasePrice().isEmpty() &&
                    form.getEngineType()!=null && !form.getEngineType().isEmpty() &&
                    form.getTransmission()!=null && !form.getTransmission().isEmpty() &&
                    form.getFuelType()!=null && !form.getFuelType().isEmpty() &&
                    form.getSeatingCapacity()!=null && !form.getSeatingCapacity().isEmpty()&&
                    form.getWarrantyDurationMonths()!=null && !form.getWarrantyDurationMonths().isEmpty() &&
                    form.getWarrantyKmLimit()!=null && !form.getWarrantyKmLimit().isEmpty()) {
                res = service.updateCarModels(form);
            }
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @GetMapping("/GetCarModels")
    public CarModelsResForm getCarModels(@RequestParam  String id){
        CarModelsResForm res=null;
        try{
            if(id!=null && !id.isEmpty())
                res = service.getCarModels(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }



    @GetMapping("/GetAllCarModels")
    public List<CarModelsResForm> getAllCarModels(){
        List<CarModelsResForm> res;
        try{
            res = service.getAllCarModels();
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @DeleteMapping("/DeleteCarModels")
    public String deleteCarModels(@RequestParam String id){
        String res=null;
        try{
            if(id!=null && !id.isEmpty())
                    res=service.deleteCarModels(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}

