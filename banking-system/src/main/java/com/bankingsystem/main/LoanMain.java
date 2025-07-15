package com.bankingsystem.main;

import com.bankingsystem.controller.LoanController;
import com.bankingsystem.form.LoanForm;

import java.sql.Date;
import java.util.Scanner;

public class LoanMain {
    public static void main(String[] args) {
        LoanController controller = new LoanController();
        LoanForm form = new LoanForm();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n---- Loan Management System ----");
            System.out.println("1. Add Loan");
            System.out.println("2. Get All Loans");
            System.out.println("3. Get Loan by ID");
            System.out.println("4. Update Loan");
            System.out.println("5. Delete Loan");
            System.out.println("6. ApproveLoan");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the Customer Id: ");
                    form.setCustomerID(scanner.nextInt());
                    System.out.print("Enter the Loan Type Id: ");
                    form.setLoanTypeId(scanner.nextInt());
                    System.out.print("Enter the Branch Id: ");
                    form.setBranchId(scanner.nextInt());
                    System.out.print("Enter the Status Id: ");
                    form.setStatusId(scanner.nextInt());
                    System.out.print("Enter the term Months");
                    form.setTermMonths(scanner.nextInt());
                    System.out.print("Enter Principal Amount: ");
                    form.setPrincipalAmount(scanner.nextFloat());
                    controller.addLoan(form);
                    break;
                case 2:
                    controller.getAllLoans();
                    break;
                case 3:
                    System.out.print("Enter the Loan Id to fetch: ");
                    int loanId = scanner.nextInt();
                    controller.getLoan(loanId);
                    break;
                case 4:
                    System.out.print("Enter the Loan Id to update: ");
                    form.setLoanId(scanner.nextInt());
                    System.out.print("Enter the Updated Status Id: ");
                    form.setStatusId(scanner.nextInt());
                    System.out.print("Enter the Term months: ");
                    form.setTermMonths(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Enter the Start Date (yyyy-mm-dd): ");
                    form.setStartDate(Date.valueOf(scanner.nextLine()));
                    System.out.print("Enter the End Date (yyyy-mm-dd): ");
                    form.setEndDate(Date.valueOf(scanner.nextLine()));
                    controller.updateLaon(form);
                    break;
                case 5:
                    System.out.print("Enter the Loan Id to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteLoan(deleteId);
                    break;

                case 6:
                    System.out.print("Enter the Loan Id to approve: ");
                    int approveId = scanner.nextInt();
                    controller.approveLoan(approveId);
                    break;
                case 7:
                    System.out.println("Exiting Loan Management System. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice Please try again.");
            }
        }
    }
}