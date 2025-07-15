package com.jocata.los.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping("/addProduct")
    public String addProduct(){
        return "Product Added Successfully";
    }
}
