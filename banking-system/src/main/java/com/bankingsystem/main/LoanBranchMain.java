package com.bankingsystem.main;

import com.bankingsystem.controller.LoanBranchController;
import com.bankingsystem.form.LoanBranchForm;

import java.util.Scanner;

public class LoanBranchMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoanBranchController controller = new LoanBranchController();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Loan Branch Management ---");
            System.out.println("1. Add Branch");
            System.out.println("2. View All Branches");
            System.out.println("3. View Branch by ID");
            System.out.println("4. Update Branch");
            System.out.println("5. Delete Branch");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LoanBranchForm addForm = new LoanBranchForm();
                    System.out.print("Enter branch name: ");
                    addForm.setName(scanner.nextLine());
                    System.out.print("Enter address: ");
                    addForm.setAddress(scanner.nextLine());
                    System.out.print("Enter city: ");
                    addForm.setCity(scanner.nextLine());
                    System.out.print("Enter state: ");
                    addForm.setState(scanner.nextLine());
                    System.out.println(controller.addBranch(addForm));
                    break;
                case 2:
                    controller.getAllBranches();
                    break;
                case 3:
                    System.out.print("Enter branch ID: ");
                    int id = scanner.nextInt();
                    controller.getBranch(id);
                    break;
                case 4:
                    LoanBranchForm updateForm = new LoanBranchForm();
                    System.out.print("Enter branch ID: ");
                    updateForm.setBranchId(scanner.nextLine());
                    System.out.print("Enter new name: ");
                    updateForm.setName(scanner.nextLine());
                    System.out.print("Enter new address: ");
                    updateForm.setAddress(scanner.nextLine());
                    System.out.print("Enter new city: ");
                    updateForm.setCity(scanner.nextLine());
                    System.out.print("Enter new state: ");
                    updateForm.setState(scanner.nextLine());
                    System.out.println(controller.updateBranch(updateForm));
                    break;
                case 5:
                    System.out.print("Enter branch ID to delete: ");
                    int deleteId = scanner.nextInt();
                    System.out.println(controller.deleteBranch(deleteId));
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
