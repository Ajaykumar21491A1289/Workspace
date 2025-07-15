package com.jocata.ordermanagementsystem.main;

import java.util.Scanner;
import com.jocata.ordermanagementsystem.controller.CustomerController;
import com.jocata.ordermanagementsystem.form.CustomerForm;

public class CustomerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerController controller = new CustomerController();
        int choice;

        do {
            System.out.println("\n--- Customer Management System ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Get Customer by ID");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            CustomerForm form = new CustomerForm();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    form.setCustomerId(sc.nextLine());
                    System.out.print("Enter Name: ");
                    form.setName(sc.nextLine());
                    System.out.print("Enter Email: ");
                    form.setEmail(sc.nextLine());
                    System.out.print("Enter Address: ");
                    form.setText(sc.nextLine());
                    System.out.println(controller.addCustomer(form));
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    form.setCustomerId(sc.nextLine());
                    System.out.print("Enter Updated Name: ");
                    form.setName(sc.nextLine());
                    System.out.print("Enter Updated Email: ");
                    form.setEmail(sc.nextLine());
                    System.out.print("Enter Updated Address: ");
                    form.setText(sc.nextLine());
                    System.out.println(controller.updateCustomer(form));
                    break;

                case 3:
                    System.out.print("Enter Customer ID to Retrieve: ");
                    int customerIdToGet = Integer.parseInt(sc.nextLine());
                    CustomerForm retrieved = controller.getCustomer(customerIdToGet);
                    if (retrieved != null) {
                        System.out.println("Customer ID: " + retrieved.getCustomerId());
                        System.out.println("Name: " + retrieved.getName());
                        System.out.println("Email: " + retrieved.getEmail());
                        System.out.println("Address: " + retrieved.getAddress());
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Customer ID to Delete: ");
                    int customerIdToDelete = Integer.parseInt(sc.nextLine());
                    System.out.println(controller.deleteCustomer(customerIdToDelete));
                    break;

                case 5:
                    System.out.println("Exiting Customer Management System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
