package com.jocata.microservices.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Employeer {

    @Autowired
    private RestTemplate restTemplate;

    public String getEmployee(){

        String url ="http://localhost:8080/employee-management/get/employee";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        return responseEntity.getBody();
    }
}
