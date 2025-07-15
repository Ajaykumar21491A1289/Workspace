package com.jocata.AdharCard.controller;

import com.jocata.AdharCard.entity.PayLoad;
import com.jocata.AdharCard.form.AadharCardResForm;
import com.jocata.AdharCard.service.AadharCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api/v2")
public class AadharCardController {

    @Autowired
    AadharCardService service;

    @PostMapping("/getAadharCardDetails")
    public AadharCardResForm getAadharCardDetails(@RequestBody PayLoad data){

        PayLoad result=null;
        try {
            result = service.getAadharCardDetails(data.getNumber());
            if(result!=null){
                return new AadharCardResForm(result,"Success","Aadhar Card Data Found",new Timestamp(System.currentTimeMillis()));
            }
            else{
                return new AadharCardResForm(result,"Failed","Record Not Found",new Timestamp(System.currentTimeMillis()));
            }
        } catch (Exception e) {
            return new AadharCardResForm(result,"Error",e.getMessage(),new Timestamp(System.currentTimeMillis()));
        }

    }

    @GetMapping("/getAadharCardDetails")
    public AadharCardResForm getAadharCardDetails(@RequestParam String aadharId){

        PayLoad result=null;
        try {
            result = service.getAadharCardDetails(aadharId);
            if(result!=null){
                return new AadharCardResForm(result,"Success","Aadhar Card Data Found",new Timestamp(System.currentTimeMillis()));
            }
            else{
                return new AadharCardResForm(result,"Failed","Record Not Found",new Timestamp(System.currentTimeMillis()));
            }
        } catch (Exception e) {
            return new AadharCardResForm(result,"Error",e.getMessage(),new Timestamp(System.currentTimeMillis()));
        }
    }
}
