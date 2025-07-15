package com.jocata.los;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class EmiCalculator {

    public static class EmiMonth {
        public int month;
        public BigDecimal principal;
        public BigDecimal interest;
        public BigDecimal emi;
        public BigDecimal remainingBalance;

    }

    public static List<EmiMonth> generateSchedule(BigDecimal loanAmount, BigDecimal annualRate, int months) {
        BigDecimal monthlyRate = annualRate.divide(BigDecimal.valueOf(12 * 100), 10, RoundingMode.HALF_UP);
        BigDecimal onePlusR = monthlyRate.add(BigDecimal.ONE);
        BigDecimal power = onePlusR.pow(months);
        BigDecimal emi = loanAmount.multiply(monthlyRate).multiply(power)
                .divide(power.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);

        List<EmiMonth> schedule = new ArrayList<>();
        BigDecimal balance = loanAmount;

        for (int i = 1; i <= months; i++) {
            BigDecimal interest = balance.multiply(monthlyRate).setScale(2, RoundingMode.HALF_UP);
            BigDecimal principal = emi.subtract(interest).setScale(2, RoundingMode.HALF_UP);
            balance = balance.subtract(principal).setScale(2, RoundingMode.HALF_UP);

            EmiMonth monthData = new EmiMonth();
            monthData.month = i;
            monthData.interest = interest;
            monthData.principal = principal;
            monthData.emi = emi;
            monthData.remainingBalance = balance.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : balance;

            schedule.add(monthData);
        }

        return schedule;
    }
}
