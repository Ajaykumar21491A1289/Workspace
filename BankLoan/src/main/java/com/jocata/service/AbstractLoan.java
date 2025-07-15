package com.jocata.service;

abstract class AbstractLoan implements Loan{

    private Integer tenure;
    private Integer rateOfIntrest;
    private Integer amount;

    AbstractLoan(Integer tenure,Integer rateOfIntrest,Integer amount){
        this.tenure=tenure;
        this.rateOfIntrest=rateOfIntrest;
        this.amount = amount;
    }

    public Integer getTenure() {
        return tenure;
    }

    public Integer getRateOfIntrest() {
        return rateOfIntrest;
    }

    public Integer getAmount() {
        return amount;
    }

    public void displayLoanDetails(Customer c){
        System.out.println("Customer Name is "+c.getName());
        System.out.println("Customer ID is "+c.getId());
        System.out.println(tenure);
        System.out.println(rateOfIntrest);
        System.out.println(amount);
    }


}
