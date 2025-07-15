package com.jocata.order.main;

import java.util.Scanner;
import com.jocata.order.controller.OrderController;
import com.jocata.order.form.OrderForm;

public class Main {

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            OrderController controller = new OrderController();

            int choice;
            do {
                System.out.println("\n--- Order Management System ---");
                System.out.println("1. Create Order");
                System.out.println("2. Update Order");
                System.out.println("3. View All Orders");
                System.out.println("4. View Order by ID");
                System.out.println("5. Cancel Order");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());

                OrderForm form = new OrderForm();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Order ID: ");
                        form.setOrderId(sc.nextLine());

                        System.out.print("Enter Item Name: ");
                        form.setItemName(sc.nextLine());

                        System.out.print("Enter Quantity: ");
                        form.setQuantity(sc.nextLine());

                        System.out.print("Enter Order Address: ");
                        form.setOrderAddress(sc.nextLine());

                        System.out.print("Enter Phone Number: ");
                        form.setPhoneNumber(sc.nextLine());

                        System.out.print("Enter Customer Name: ");
                        form.setCustomerName(sc.nextLine());

                        String result = controller.createOrder(form);
                        System.out.println(result);
                        break;

                    case 2:
                        System.out.print("Enter Order ID: to Modify ");
                        form.setOrderId(sc.nextLine());

                        System.out.print("Enter Item Name: ");
                        form.setItemName(sc.nextLine());

                        System.out.print("Enter Quantity: ");
                        form.setQuantity(sc.nextLine());

                        System.out.print("Enter Order Address: ");
                        form.setOrderAddress(sc.nextLine());

                        System.out.print("Enter Phone Number: ");
                        form.setPhoneNumber(sc.nextLine());

                        System.out.print("Enter Customer Name: ");
                        form.setCustomerName(sc.nextLine());

                        System.out.println(controller.updateOrder(form));
                        break;

                    case 3:
                        controller.getAllOrders();

                        break;

                    case 4:
                        System.out.println("Enter the Order Id");
                        form.setOrderId(sc.nextLine());
                        controller.getOrder(form.getOrderId());
                        break;

                    case 5:
                        System.out.println("Enter the OrderId to Delete");
                        form.setOrderId(sc.nextLine());
                        controller.cancelOrder(form.getOrderId());
                        break;

                    case 6:
                        System.out.println("Exiting Order Management System...");
                        OrderController.closeController();
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 6);

            sc.close();
        }
    }


