package com.jocata.warranty_system.controller;

import com.jocata.warranty_system.form.CarModelsResForm;
import com.jocata.warranty_system.form.CarTypesReqForm;
import com.jocata.warranty_system.form.CarTypesResForm;
import com.jocata.warranty_system.service.CarTypesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v5")
public class CarTypesControleer {

    @Autowired
    CarTypesService service;

    @PostMapping("/AddCarType")
    public CarTypesResForm addCarType(@Valid @RequestBody CarTypesReqForm form){
        CarTypesResForm res=null;
        try{
            if(form.getName()!=null && !form.getName().isEmpty())
                  res = service.addCarType(form);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @PutMapping("/UpdateCarType")
    public CarTypesResForm updateCarType(@Valid @RequestBody CarTypesReqForm form){
        CarTypesResForm res=null;
        try{
            if(form.getId()!=null && form.getId().isEmpty() &&
            form.getName()!=null && form.getName().isEmpty())
                    res = service.updateCarType(form);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/GetCarType")
    public CarTypesResForm getCarType(@RequestParam String id){
        CarTypesResForm res=null;
        try{
            if(id!=null && !id.isEmpty())
                 res = service.getCarType(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @GetMapping("/GetAllCarTypes")
    public List<CarTypesResForm> getAllCarTypes(){
        List<CarTypesResForm> res = null;
        try{
            res = service.getAllCarTypes();
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @DeleteMapping("/DeleteCarTypes")
    public String deleteCarType(@RequestParam String id){
        String res=null;
        try{
            if(id!=null && !id.isEmpty())
                    res = service.deleteCarType(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
