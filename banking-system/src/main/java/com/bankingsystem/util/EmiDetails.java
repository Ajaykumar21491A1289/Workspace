package com.bankingsystem.util;

public class EmiDetails {

    int month;
    float emi;
    float principalComponent;
    float interestComponent;
    float balance;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public float getEmi() {
        return emi;
    }

    public void setEmi(float emi) {
        this.emi = emi;
    }

    public float getPrincipalComponent() {
        return principalComponent;
    }

    public void setPrincipalComponent(float principalComponent) {
        this.principalComponent = principalComponent;
    }

    public float getInterestComponent() {
        return interestComponent;
    }

    public void setInterestComponent(float interestComponent) {
        this.interestComponent = interestComponent;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public EmiDetails(int month, float emi, float principalComponent, float interestComponent, float balance) {
        this.month = month;
        this.emi = emi;
        this.principalComponent = principalComponent;
        this.interestComponent = interestComponent;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Month " + month +
                " | EMI: " + emi +
                " | Principal: " + principalComponent +
                " | Interest: " + interestComponent +
                " | Balance: " + balance;
    }
}
