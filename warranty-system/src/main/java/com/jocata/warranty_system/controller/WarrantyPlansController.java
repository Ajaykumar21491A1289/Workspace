package com.jocata.warranty_system.controller;

import com.jocata.warranty_system.Dao.WarrantyPlansDao;
import com.jocata.warranty_system.form.WarrantyPlansReqForm;
import com.jocata.warranty_system.form.WarrantyPlansResForm;
import com.jocata.warranty_system.form.WarrantyTypesResForm;
import com.jocata.warranty_system.service.WarrantyPlansService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v6")
public class WarrantyPlansController {

    @Autowired
    WarrantyPlansService service;

    @PostMapping("/AddWarrantyPlan")
    public WarrantyPlansResForm addWarrantyPlan(@Valid @RequestBody WarrantyPlansReqForm form){
        WarrantyPlansResForm res=null;
        try{
            if(form.getName()!=null && !form.getName().isEmpty() &&
            form.getDurationMonths()!=null && !form.getDurationMonths().isEmpty() &&
            form.getKmLimit()!=null && !form.getKmLimit().isEmpty() &&
            form.getWarrantyType()!=null && !form.getWarrantyType().isEmpty() &&
            form.getCoverageType()!=null && !form.getCoverageType().isEmpty() &&
            form.getBasePrice()!=null && !form.getBasePrice().isEmpty() &&
            form.getSurchargePercent()!=null && !form.getSurchargePercent().isEmpty())
                    res = service.addWarrantyPlan(form);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @PutMapping("/UpdateWarrantyPlan")
    public WarrantyPlansResForm updateWarrantyPlan(@Valid@RequestBody WarrantyPlansReqForm form){
        WarrantyPlansResForm res =null;
        try{
            if(form.getPlanId()!=null && !form.getPlanId().isEmpty()&&
                    form.getName()!=null && !form.getName().isEmpty() &&
                    form.getDurationMonths()!=null && !form.getDurationMonths().isEmpty() &&
                    form.getKmLimit()!=null && !form.getKmLimit().isEmpty() &&
                    form.getWarrantyType()!=null && !form.getWarrantyType().isEmpty() &&
                    form.getCoverageType()!=null && !form.getCoverageType().isEmpty() &&
                    form.getBasePrice()!=null && !form.getBasePrice().isEmpty() &&
                    form.getSurchargePercent()!=null && !form.getSurchargePercent().isEmpty())
                          res = service.updateWarrantyPlan(form);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/GetWarrantyPlan")
    public WarrantyPlansResForm getWarrantyPlan(@RequestParam String id){
        WarrantyPlansResForm res =null;
        try{
            if(id!=null && !id.isEmpty())
                res = service.getWarrantyPlan(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/GetAllWarrantyPlan")

    public List<WarrantyPlansResForm> getAllWarrantyPlan(){
        List<WarrantyPlansResForm> res =null;
        try{
            res = service.getAllWarrantyPlan();
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @DeleteMapping("/DeleteWarrantyPlan")
    public String deleteWarrantyPlan(String id) {
        String res =null;
        try{
            if(id!=null && !id.isEmpty())
                    res = service.deleteWarrantyPlan(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
