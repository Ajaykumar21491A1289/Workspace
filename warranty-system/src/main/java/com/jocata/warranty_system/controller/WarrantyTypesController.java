package com.jocata.warranty_system.controller;

import com.jocata.warranty_system.entity.WarrantyTypes;
import com.jocata.warranty_system.form.WarrantyTypesReqForm;
import com.jocata.warranty_system.form.WarrantyTypesResForm;
import com.jocata.warranty_system.service.WarrantyTypesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v3")
public class WarrantyTypesController {

    @Autowired
    WarrantyTypesService service;

    @PostMapping("/CreateWarrantyType")
    public WarrantyTypesResForm addWarrantyType(@RequestBody  WarrantyTypesReqForm form){
        WarrantyTypesResForm res=null;
        try{
            if(form.getName()!=null && !form.getName().isEmpty())
                  res= service.addWarrantyType(form);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @PutMapping("/UpdateWarrantyType")
    public WarrantyTypesResForm updateWarranties(@RequestBody WarrantyTypesReqForm form){
        WarrantyTypesResForm res=null;
        try{
            if(form.getId()!=null && !form.getId().isEmpty()&&
            form.getName()!=null && !form.getName().isEmpty())
                    res = service.updateWarranty(form);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @GetMapping("/GetWarrantyType")
    public WarrantyTypesResForm getWarrantyTypes(@RequestParam String id){
        WarrantyTypesResForm res=null;
        try{
            if(id!=null && !id.isEmpty())
                 res=service.getWarrantyTypes(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/GetAllWarrantyType")
    public List<WarrantyTypesResForm> getAllWarrantyTypes(){
        List<WarrantyTypesResForm> res=null;
        try{
            res=service.getAllWarrantyTypes();
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @DeleteMapping ("/DeleteWarrantyType")
    public String deleteWarrantyTypes(@RequestParam String id){
        String res=null;
        try{
            if(id!=null && !id.isEmpty())
                res= service.deleteWarrantyTypes(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
