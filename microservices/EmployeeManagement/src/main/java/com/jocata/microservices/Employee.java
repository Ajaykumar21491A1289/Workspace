package com.jocata.microservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class Employee {

    @GetMapping("/employee")
    public String getEmployee(){
        return "I am An Employee ";
    }

}
