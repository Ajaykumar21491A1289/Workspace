package com.bankingsystem.main;

import com.bankingsystem.controller.LoanTypeController;
import com.bankingsystem.form.LoanTypeForm;

import java.util.List;
import java.util.Scanner;

public class LoanTypeMain {

    public static void main(String[] args) {
        LoanTypeController controller = new LoanTypeController();
        LoanTypeForm form = new LoanTypeForm();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println(" Banking System Menu ");
            System.out.println("1. Add Loan Type");
            System.out.println("2. View All Loan Types");
            System.out.println("3. View Particular Loan Type");
            System.out.println("4. Update Loan Type");
            System.out.println("5. Delete Loan Type");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the Type Of The Loan: ");
                    form.setLoanType(scanner.nextLine());
                    System.out.print("Enter the Rate Of Intrest: ");
                    form.setIntrestRate(scanner.nextLine());
                    System.out.println(controller.addLoanType(form));
                    break;

                case 2:
                    List<LoanTypeForm> forms = controller.getAllLaonTypes();
                    for(LoanTypeForm formType:forms){
                        System.out.println(formType.getLoanTypeId() +" "+formType.getLoanType()+" "+formType.getIntrestRate());
                    }
                    break;

                case 3:
                    System.out.print("Enter the Loan Type Id: ");
                    Integer id = scanner.nextInt();
                    controller.getLoanType(id);
                    break;

                case 4:
                    System.out.print("Enter The Loan Type Id: ");
                    form.setLoanTypeId(scanner.nextLine());
                    System.out.print("Enter the Type Of The Loan: ");
                    form.setLoanType(scanner.nextLine());
                    System.out.print("Enter the Rate Of Intrest: ");
                    form.setIntrestRate(scanner.nextLine());
                    System.out.println(controller.updateLoanType(form));
                    break;

                case 5:
                    System.out.print("Enter the Loan Type Id to Delete: ");
                    Integer value = scanner.nextInt();
                    System.out.println(controller.deleteLaonType(value));

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
