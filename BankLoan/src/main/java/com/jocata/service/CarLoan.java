package com.jocata.service;

public class CarLoan extends AbstractLoan {
    CarLoan(Integer tenure,Integer rateOfIntrest,Integer amount){
        super(tenure,rateOfIntrest,amount);
    }
    @Override
    public void calculateEmi() {
        double monthlyRate= getRateOfIntrest()/(12*100.0);
        Integer tenureMonths = getTenure()*12;
        double emi=(getAmount()* monthlyRate*Math.pow(1+monthlyRate,tenureMonths))/(Math.pow(1+monthlyRate,tenureMonths)-1);
        System.out.println("CarLoan is"+emi);
    }
}
