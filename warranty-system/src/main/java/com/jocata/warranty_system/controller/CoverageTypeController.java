package com.jocata.warranty_system.controller;

import com.jocata.warranty_system.form.CoverageTypeReqForm;
import com.jocata.warranty_system.form.CoverageTypeResForm;
import com.jocata.warranty_system.service.CoverageTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4")
public class CoverageTypeController {

    @Autowired
    CoverageTypeService service;

    @PostMapping("/CreateCoverageType")
    public CoverageTypeResForm addCoverareType(@RequestBody CoverageTypeReqForm form) {
        CoverageTypeResForm res = null;
        try {
            if(form.getName()!=null && !form.getName().isEmpty())
                 res = service.addCoverareType(form);
            if (res != null) {
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @PutMapping("/UpdateCoverageType")
    public CoverageTypeResForm updateCoverageType(@RequestBody  CoverageTypeReqForm form) {
        CoverageTypeResForm res = null;
        try {
            if(form.getId()!=null && !form.getId().isEmpty() &&
            form.getName()!=null && !form.getName().isEmpty())
                    res = service.updateCoverageType(form);
            if (res != null) {
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/getCoverageType")
    public CoverageTypeResForm getCoverageTypes(@RequestParam String id) {
        CoverageTypeResForm res = null;
        try {
            if(id!=null && !id.isEmpty())
                    res = service.getCoverageTypes(id);
            if (res != null) {
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;

    }





    @GetMapping("/getAllCoverageType")
    public List<CoverageTypeResForm> getAllCoverageTypes(){
        List<CoverageTypeResForm> res=null;
        try {
            res = service.getAllCoverageTypes();
            if (res != null) {
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @DeleteMapping ("/DeleteCoverageType")
    public String deleteCoverageType(@RequestParam String id){
        String res=null;
        try {
            if(id!=null && !id.isEmpty())
                    res = service.deleteCoverageType(id);
            if (res != null) {
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
