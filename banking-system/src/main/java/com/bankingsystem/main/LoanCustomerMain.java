package com.bankingsystem.main;

import com.bankingsystem.controller.LoanCustomerController;
import com.bankingsystem.form.LoanCustomerForm;

import java.util.Scanner;

public class LoanCustomerMain {

    public static void main(String[] args) {
        LoanCustomerController controller = new LoanCustomerController();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Loan Customer Banking System Menu ---");
            System.out.println("1. Add Loan Customer");
            System.out.println("2. View All Loan Customers");
            System.out.println("3. View Particular Customer");
            System.out.println("4. Update Loan Customer");
            System.out.println("5. Delete Loan Customer");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LoanCustomerForm addForm = new LoanCustomerForm();
                    System.out.print("Enter name: ");
                    addForm.setName(scanner.nextLine());
                    System.out.print("Enter email: ");
                    addForm.setEmail(scanner.nextLine());
                    System.out.print("Enter phone: ");
                    addForm.setPhone(scanner.nextLine());
                    System.out.print("Enter address: ");
                    addForm.setAddress(scanner.nextLine());
                    System.out.print("Enter date of birth (yyyy-MM-dd): ");
                    addForm.setDob(scanner.nextLine());
                    System.out.println(controller.addCustomer(addForm));
                    break;

                case 2:
                    controller.getAllCustomers();
                    break;

                case 3:
                    System.out.print("Enter customer ID to view: ");
                    int viewId = scanner.nextInt();
                    controller.getCustomer(viewId);
                    break;

                case 4:
                    LoanCustomerForm updateForm = new LoanCustomerForm();
                    System.out.print("Enter customer ID to update: ");
                    updateForm.setCustomerId(scanner.nextLine());
                    System.out.print("Enter new name: ");
                    updateForm.setName(scanner.nextLine());
                    System.out.print("Enter new email: ");
                    updateForm.setEmail(scanner.nextLine());
                    System.out.print("Enter new phone: ");
                    updateForm.setPhone(scanner.nextLine());
                    System.out.print("Enter new address: ");
                    updateForm.setAddress(scanner.nextLine());
                    System.out.print("Enter new date of birth (yyyy-MM-dd): ");
                    updateForm.setDob(scanner.nextLine());
                    System.out.println(controller.updateCustomer(updateForm));
                    break;

                case 5:
                    System.out.print("Enter customer ID to delete: ");
                    int deleteId = scanner.nextInt();
                    System.out.println(controller.deleteCustomer(deleteId));
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
