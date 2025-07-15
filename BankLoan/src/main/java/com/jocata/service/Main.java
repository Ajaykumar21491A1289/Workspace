package com.jocata.service;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Name");
        String customerName=sc.nextLine();
        System.out.println("Enter CustomerID");
        Integer customerId = sc.nextInt();
        Customer c = new Customer();
        c.setDetails(customerId,customerName);
        System.out.println("Enter the tenure");
        Integer tenure = sc.nextInt();
        System.out.println("Enter the rateofintrest");
        Integer rateOfIntrest=sc.nextInt();
        System.out.println("Enter the amount");
        Integer amount=sc.nextInt();
        Loan hl = new HomeLoan(tenure,rateOfIntrest,amount);
        hl.displayLoanDetails(c);
        hl.calculateEmi();
        Loan cl = new CarLoan(tenure,rateOfIntrest,amount);
        cl.displayLoanDetails(c);
        cl.calculateEmi();
        Loan pl = new PersonalLoan(tenure,rateOfIntrest,amount);
        pl.displayLoanDetails(c);
        pl.calculateEmi();


    }
}