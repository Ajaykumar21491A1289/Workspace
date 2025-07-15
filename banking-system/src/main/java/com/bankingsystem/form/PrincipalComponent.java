package com.bankingsystem.form;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PrincipalComponent {
    public static void calculateComponents( float principal,
                                            float intrest_rate,
                                            int termMonths,
                                            LocalDate startDate,
                                            LocalDate paymentDate){

        long monthsPassed = ChronoUnit.MONTHS.between(startDate, paymentDate) + 1;

        if(monthsPassed>termMonths){
            System.out.println("Payment date exceeds");
            return;
        }
        float monthlyIntrestRate = intrest_rate/12/100;
        float emi = (float) ((principal*monthlyIntrestRate*Math.pow(1+monthlyIntrestRate,termMonths))/
                (Math.pow(1+monthlyIntrestRate,termMonths)-1));
        float balance = principal;
        for(int m=1;m<monthsPassed;m++){
            float intrest = balance*monthlyIntrestRate;
            float principalComp =emi-intrest;
            balance-=principalComp;
        }

        float interestComponent = balance * monthlyIntrestRate;
        float principalComponent = emi - interestComponent;





    }
    public static void main(String[] args){


    }
}
