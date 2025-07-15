package com.bankingsystem.main;

import com.bankingsystem.controller.LoanPaymentController;
import com.bankingsystem.form.LoanPaymentForm;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.Scanner;

public class LoanPaymentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoanPaymentController controller = new LoanPaymentController();

        while (true) {
            System.out.println("\n---- Loan Payment Management System ----");
            System.out.println("1. Add Loan Payment");
            System.out.println("2. Update Loan Payment");
            System.out.println("3. Get Loan Payment by Loan ID");
            System.out.println("4. Get All Loan Payments");
            System.out.println("5. Delete Loan Payment by Loan ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    LoanPaymentForm form = new LoanPaymentForm();
                    System.out.print("Enter Loan ID: ");
                    form.setLoanID(scanner.nextLine());
                    System.out.println(controller.addLaonPayment(form));
                    break;
                }
                case 2: {
                    LoanPaymentForm form = new LoanPaymentForm();
                    System.out.print("Enter Payment ID to Update: ");
                    form.setPaymentId(scanner.nextLine());
                    System.out.print("Enter Loan ID: ");
                    form.setLoanID(scanner.nextLine());
                    System.out.print("Enter Payment Date (yyyy-mm-dd): ");
                    form.setPaymentDate(scanner.nextLine());
                    System.out.print("Enter Amount Paid: ");
                    form.setAmountPaid(scanner.nextLine());
                    System.out.print("Enter Principal Component: ");
                    form.setPrincipalComponent(scanner.nextLine());
                    System.out.print("Enter Interest Component: ");
                    form.setIntrestComponent(scanner.nextLine());
                    System.out.println(controller.updateLoanPayment(form));
                    break;
                }
                case 3: {
                    System.out.print("Enter Loan ID: ");
                    String loanId = scanner.nextLine();
                    File file = controller.getLaonPayment(loanId);
                    if (file != null && file.exists()) {
                        System.out.println("File Created And Loaded Data Successfully");
                    } else {
                        System.out.println("No payment found for Loan ID: " + loanId);
                    }
                    break;
                }
                case 4: {
                    Path path = controller.getAllLaonPayment();
                    try {
                        List<String> lines = Files.readAllLines(path);
                        for (String line : lines) {
                            System.out.println(line);
                        }

                        Files.deleteIfExists(path);


                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    /*try {
                        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path.toFile()));
                        while (true) {
                            try {
                                LoanPaymentEntity entity = (LoanPaymentEntity) stream.readObject();
                                System.out.println("PaymentId: " + entity.getPaymentId() + "  " + "Laon Id: " + entity.getLoanID() + "  " + "Payment Date: " + entity.getPaymentDate() + "  " + "Amount Paid:  " + entity.getAmountPaid() + "  " + "Principal Component: " + entity.getPrincipalComponent() + "  " + "Intrest Component " + entity.getIntrestComponent());

                            } catch (EOFException e) {
                                break;
                            }
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }*/
                    break;
                }

                case 5: {
                    System.out.print("Enter Loan ID to delete: ");
                    String loanId = scanner.nextLine();
                    String result = controller.deleteLaon(loanId);
                    System.out.println(result);
                    break;
                }
                case 6:
                    System.out.println("Exiting Loan Payment System. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
