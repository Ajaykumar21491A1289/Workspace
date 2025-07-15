package com.bankingsystem.main;

import com.bankingsystem.controller.*;
import com.bankingsystem.form.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LoanBranchController branchController = new LoanBranchController();
        LoanCustomerController customerController = new LoanCustomerController();
        LoanStatusController statusController = new LoanStatusController();
        LoanTypeController typeController = new LoanTypeController();

        boolean running = true;
        while (running) {
            System.out.println("\n--- Banking System Main Menu ---");
            System.out.println("1. Manage Loan Branch");
            System.out.println("2. Manage Loan Customer");
            System.out.println("3. Manage Loan Status");
            System.out.println("4. Manage Loan Type");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    manageLoanBranch(scanner, branchController);
                    break;
                case 2:
                    manageLoanCustomer(scanner, customerController);
                    break;
                case 3:
                    manageLoanStatus(scanner, statusController);
                    break;
                case 4:
                    manageLoanType(scanner, typeController);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting Banking System");
                    break;
                default:
                    System.out.println("Invalid choice Try again");
            }
        }

        scanner.close();
    }

    private static void manageLoanBranch(Scanner scanner, LoanBranchController controller) {
        boolean subRunning = true;
        while (subRunning) {
            System.out.println("\n--- Loan Branch Management ---");
            System.out.println("1. Add Branch");
            System.out.println("2. View All Branches");
            System.out.println("3. View Branch by ID");
            System.out.println("4. Update Branch");
            System.out.println("5. Delete Branch");
            System.out.println("6. Back to Main Menu");
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
                    controller.getBranch(scanner.nextInt());
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
                    System.out.println(controller.deleteBranch(scanner.nextInt()));
                    break;
                case 6:
                    subRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void manageLoanCustomer(Scanner scanner, LoanCustomerController controller) {
        boolean subRunning = true;
        while (subRunning) {
            System.out.println("\n--- Loan Customer Banking System Menu ---");
            System.out.println("1. Add Loan Customer");
            System.out.println("2. View All Loan Customers");
            System.out.println("3. View Particular Customer");
            System.out.println("4. Update Loan Customer");
            System.out.println("5. Delete Loan Customer");
            System.out.println("6. Back to Main Menu");
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
                    controller.getCustomer(scanner.nextInt());
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
                    System.out.println(controller.deleteCustomer(scanner.nextInt()));
                    break;
                case 6:
                    subRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void manageLoanStatus(Scanner scanner, LoanStatusController controller) {
        boolean subRunning = true;
        while (subRunning) {
            System.out.println("\n--- Loan Status Banking System Menu ---");
            System.out.println("1. Add Loan Status");
            System.out.println("2. View All Loan Status");
            System.out.println("3. View Particular Status");
            System.out.println("4. Update Loan Status");
            System.out.println("5. Delete Loan Status");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LoanStatusForm addForm = new LoanStatusForm();
                    System.out.print("Enter status name: ");
                    addForm.setStatusName(scanner.nextLine());
                    controller.addLoanStatus(addForm);
                    System.out.println("Loan status added.");
                    break;
                case 2:
                    controller.getAllLaonStatus();
                    break;
                case 3:
                    System.out.print("Enter the Status ID: ");
                    controller.getLoan(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new status name: ");
                    String name = scanner.nextLine();
                    LoanStatusForm form = new LoanStatusForm();
                    form.setStatsId(updateId);
                    form.setStatusName(name);
                    controller.updateLoanStatus(form);
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    controller.deleteLoan(scanner.nextInt());
                    break;
                case 6:
                    subRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void manageLoanType(Scanner scanner, LoanTypeController controller) {
        boolean subRunning = true;
        LoanTypeForm form = new LoanTypeForm();

        while (subRunning) {
            System.out.println("\n--- Loan Type Banking System Menu ---");
            System.out.println("1. Add Loan Type");
            System.out.println("2. View All Loan Types");
            System.out.println("3. View Particular Loan Type");
            System.out.println("4. Update Loan Type");
            System.out.println("5. Delete Loan Type");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the Type of the Loan: ");
                    form.setLoanType(scanner.nextLine());
                    System.out.print("Enter the Rate of Interest: ");
                    form.setIntrestRate(scanner.nextLine());
                    System.out.println(controller.addLoanType(form));
                    break;
                case 2:
                    List<LoanTypeForm> forms = controller.getAllLaonTypes();
                    for (LoanTypeForm f : forms) {
                        System.out.println(f.getLoanTypeId() + " " + f.getLoanType() + " " + f.getIntrestRate());
                    }
                    break;
                case 3:
                    System.out.print("Enter the Loan Type ID: ");
                    controller.getLoanType(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter the Loan Type ID: ");
                    form.setLoanTypeId(scanner.nextLine());
                    System.out.print("Enter the Type of the Loan: ");
                    form.setLoanType(scanner.nextLine());
                    System.out.print("Enter the Rate of Interest: ");
                    form.setIntrestRate(scanner.nextLine());
                    System.out.println(controller.updateLoanType(form));
                    break;
                case 5:
                    System.out.print("Enter the Loan Type ID to delete: ");
                    System.out.println(controller.deleteLaonType(scanner.nextInt()));
                    break;
                case 6:
                    subRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
