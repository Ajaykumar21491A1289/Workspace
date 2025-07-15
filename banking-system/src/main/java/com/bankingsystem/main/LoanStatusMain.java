package com.bankingsystem.main;

import com.bankingsystem.controller.LoanStatusController;
import com.bankingsystem.form.LoanStatusForm;

import java.util.Scanner;

public class LoanStatusMain {

    public static void main(String[] args) {
        LoanStatusController controller = new LoanStatusController();
        LoanStatusForm form = new LoanStatusForm();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Loan Status Banking System Menu ---");
            System.out.println("1. Add Loan Status");
            System.out.println("2. View Loan Status");
            System.out.println("3. View Particular Status");
            System.out.println("4. Update Loan Status");
            System.out.println("5. Delete Loan Status");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LoanStatusForm addForm = new LoanStatusForm();
                    System.out.print("Enter status name to add: ");
                    addForm.setStatusName(scanner.nextLine());
                    System.out.println(controller.addLoanStatus(addForm));
                    break;

                case 2:
                    System.out.println("Viewing loan statuses...");
                    controller.getAllLaonStatus();
                    break;

                case 3:
                    System.out.print("Enter the Status Id you Want: ");
                    Integer id =scanner.nextInt();
                    controller.getLoan(id);
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    String updateId = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Enter new status name: ");
                    String name= scanner.nextLine();
                    form.setStatusName(name);
                    form.setStatsId(updateId);
                    System.out.println(controller.updateLoanStatus(form));
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteLoan(deleteId);
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting...");

                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
