package com.bankingsystem.util;

import java.util.List;

public class Main {

    public static void main(String[] args){
        List<EmiDetails> list = EmiCalculated.calculateEmi(1000,10,2);
        for(EmiDetails details:list){
            System.out.println(details.emi+"         "+details.month+"       "+details.balance+"        "+details.balance+"          "+details.principalComponent+"     "+details.interestComponent);
            System.out.println("------------------");
        }
        System.out.println(list.get(1));
    }
}
