package com.jocata.service;

public class Customer {

    private Integer customerId;
    private String customerName;
    public void setDetails(Integer customerId, String customerName){
        this.customerId = customerId;
        this.customerName=customerName;
    }
    public  String getName(){
        return customerName;
    }
    public  Integer getId(){
        return customerId;
    }

}



