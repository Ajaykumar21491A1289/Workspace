package com.jocata.PanService.controller;

import com.jocata.PanService.entity.PanDetails;
import com.jocata.PanService.form.PanDetailsResForm;
import com.jocata.PanService.service.PanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api/v1")
public class PanServiceController {

    @Autowired
    PanService service;

    @PostMapping("/getPanDetails")
    public PanDetailsResForm  getPanDetails(@RequestBody PanDetails details){
        PanDetails entity =null;
        try {
            entity = service.getPanDetails(details.getPanNumber());
            if(entity!=null){
                return new PanDetailsResForm(entity,"Sucess","Pan Details Found",new Timestamp(System.currentTimeMillis()));
            }
            else{
                return new PanDetailsResForm(entity,"Failed","Pan Details Not Found",new Timestamp(System.currentTimeMillis()));
            }

        } catch (Exception e) {
            return new PanDetailsResForm(entity,"Error",e.getMessage(),new Timestamp(System.currentTimeMillis()));
        }
    }

    @GetMapping("/getPanDetails")
    public PanDetailsResForm getPanDetails(@RequestParam String panNumber){

        PanDetails entity =null;
        try {
            entity = service.getPanDetails(panNumber);
            if(entity!=null){
                return new PanDetailsResForm(entity,"Sucess","Pan Details Found",new Timestamp(System.currentTimeMillis()));
            }
            else{
                return new PanDetailsResForm(entity,"Failed","Pan Details Not Found",new Timestamp(System.currentTimeMillis()));
            }

        } catch (Exception e) {
            return new PanDetailsResForm(entity,"Error",e.getMessage(),new Timestamp(System.currentTimeMillis()));
        }
    }



    /*public Object getPanDetails(@PathVariable ){

    }*/
}
