package com.jocata.oms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductsController {

    @GetMapping("/getProduct/{productId}")
    public String getProductDetails(@PathVariable Integer productId){
        return "Mobile";
    }
}
