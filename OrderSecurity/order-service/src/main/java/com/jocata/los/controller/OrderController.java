package com.jocata.los.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/placeOrder")
    public String placeOrder(){
        return "Order Placed Successfully";
    }
}
