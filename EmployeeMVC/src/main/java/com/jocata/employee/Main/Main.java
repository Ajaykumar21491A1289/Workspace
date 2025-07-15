package com.jocata.employee.Main;
import java.util.*;
import com.jocata.employee.controller.LoginController;
import com.jocata.employee.form.EmployeeForm;

public class Main {

    public static void main(String[] args){

        LoginController loginController = new LoginController();

        Scanner sc = new Scanner(System.in);

        Integer choice;
        do{
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            EmployeeForm form = new EmployeeForm();

            switch(choice){
                case 1:
                    System.out.print("Enter Employee ID: ");
                    form.setId(sc.nextLine());

                    System.out.print("Enter Name: ");
                    form.setUserName(sc.nextLine());

                    System.out.print("Enter Designation: ");
                    form.setDesignation(sc.nextLine());

                    System.out.print("Enter Salary: ");
                    form.setSalary(sc.nextLine());

                    System.out.print("Enter Date of Joining (yyyy-mm-dd): ");
                    form.setDataOfJoin(sc.nextLine());

                    System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
                    form.setDateOfBirth(sc.nextLine());

                    loginController.addEmployee(form);
                    break;

                case 2:

                    System.out.print("Enter Employee ID to search: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Employee Name to verify: ");
                    String name = sc.nextLine();

                    System.out.println(loginController.searchEmployee(id,name));
                    break;

                case 3:

                    System.out.print("Enter Employee ID to delete: ");
                    id = sc.nextLine();

                    System.out.println(loginController.deleteEmployee(id));
                    break;

                case 4:

                    System.out.print("Enter Employee ID to update: ");
                    form.setId(sc.nextLine());

                    System.out.print("Enter New Name: ");
                    form.setUserName(sc.nextLine());

                    System.out.print("Enter New Designation: ");
                    form.setDesignation(sc.nextLine());

                    System.out.print("Enter New Salary: ");
                    form.setSalary(sc.nextLine());

                    System.out.print("Enter New Date of Joining (yyyy-mm-dd): ");
                    form.setDataOfJoin(sc.nextLine());

                    System.out.print("Enter New Date of Birth (yyyy-mm-dd): ");
                    form.setDateOfBirth(sc.nextLine());

                    System.out.println(loginController.updateEmployee(form));
                    break;



                case 5:

                    LoginController.closeController();
                    break;


                default:

                    System.out.println("Invalid Choice");


            }

        }while(choice!=5);

    }
}
