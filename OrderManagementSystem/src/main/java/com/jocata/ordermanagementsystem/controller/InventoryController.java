package com.jocata.ordermanagementsystem.controller;

import com.jocata.ordermanagementsystem.entity.InventoryEntity;
import com.jocata.ordermanagementsystem.form.InventoryForm;
import com.jocata.ordermanagementsystem.service.InventoryService;
import com.jocata.ordermanagementsystem.service.imp.InventoryServiceImpl;

public class InventoryController {

    InventoryService service = new InventoryServiceImpl();

    public String updateInventory(InventoryForm form){
        if(form.getProductId()!=null && !form.getProductId().isEmpty() &&
        form.getStock()!=null && !form.getStock().isEmpty()){
           return service.updateInventory(form);
        }
        return "Validation Not Satisfied";
    }
    public int getCurrentStock(Integer productId){

        if(productId!=null) {
            return service.getCurrentStock(productId);
        }
        return 0;
    }
    public String reduceStock(Integer productId, Integer quantity){
        if(productId!=null && quantity!=null) {


            return service.reduceStock(productId, quantity);
        }
        return "Validation Not Satisfied";
    }
    public InventoryEntity getInventory(Integer productId){
        if(productId!=null){
            return service.getInventory(productId);
        }
        return null;
    }

}
