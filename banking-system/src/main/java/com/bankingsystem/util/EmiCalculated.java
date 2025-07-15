package com.bankingsystem.util;

import java.util.ArrayList;
import java.util.List;

public class EmiCalculated {

    public static List<EmiDetails> calculateEmi(float principalAmount, float interestRate, int termMonths) {
        List<EmiDetails> emiList = new ArrayList<>();
        float monthlyRate = interestRate / (12 * 100);

        float emi = (float) ((principalAmount * monthlyRate * Math.pow(1 + monthlyRate, termMonths)) /
                (Math.pow(1 + monthlyRate, termMonths) - 1));

        float remainingPrincipal = principalAmount;

        for (int month = 1; month <= termMonths; month++) {
            float interestComponent = remainingPrincipal * monthlyRate;
            float principalComponent = emi - interestComponent;
            remainingPrincipal -= principalComponent;

            emiList.add(new EmiDetails(month, emi, principalComponent, interestComponent,
                    Math.max(0, remainingPrincipal)));
        }

        return emiList;
    }

}

