package com.jocata.ordermanagementsystem.main;

import com.jocata.ordermanagementsystem.controller.InventoryController;
import com.jocata.ordermanagementsystem.controller.OrderHistoryController;
import com.jocata.ordermanagementsystem.controller.OrderManagerController;
import com.jocata.ordermanagementsystem.controller.PaymentController;
import com.jocata.ordermanagementsystem.form.OrderForm;

import java.util.List;
import java.util.Scanner;

public class OrderMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderManagerController controller = new OrderManagerController();
        OrderHistoryController historyController = new OrderHistoryController();

        int choice;
        do {
            System.out.println("\n--- Order Management System ---");
            System.out.println("1. Create Order");
            System.out.println("2. Update Order");
            System.out.println("3. Get Order by Index");
            System.out.println("4. Cancel Order");
            System.out.println("5. View Completed Orders");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    OrderForm newOrder = new OrderForm();
                    InventoryController inventoryController = new InventoryController();
                    PaymentController paymentController = new PaymentController(); // instantiate payment controller

                    System.out.print("Enter Product ID: ");
                    newOrder.setProductId(Integer.parseInt(sc.nextLine()));

                    System.out.print("Enter Customer ID: ");
                    newOrder.setCustomerId(Integer.parseInt(sc.nextLine()));

                    System.out.print("Enter the Quantity you want");
                    Integer quantity = sc.nextInt();
                    newOrder.setOrderQuantity(quantity);

                    inventoryController.reduceStock(newOrder.getProductId(), quantity);

                    // Handle scanner line issue after nextInt
                    sc.nextLine();

                    // Assume unit price is fetched here (optional - can be fetched inside PaymentService too)
                    System.out.print("Enter amount to pay: ");
                    Integer amountPaid = sc.nextInt();

                    String paymentResult = paymentController.payment(newOrder.getProductId(), amountPaid);
                    System.out.print("Payment Status: " + paymentResult);

                    if (paymentResult.equals("Payment Processed Successfully")) {
                        newOrder.setStatus("Confirmed");
                        controller.createOrder(newOrder);
                    } else {
                        newOrder.setStatus("Payment Failed");
                        System.out.print("Order not created due to failed payment.");
                    }
                    break;


                case 2:
                    OrderForm updateOrder = new OrderForm();
                    System.out.print("Enter Product ID: ");
                    updateOrder.setProductId(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter Customer ID: ");
                    updateOrder.setCustomerId(Integer.parseInt(sc.nextLine()));
                    System.out.print("Enter Updated Status: ");
                    updateOrder.setStatus(sc.nextLine());
                    controller.updateOrder(updateOrder);
                    break;

                case 3:
                    System.out.print("Enter Order Index to Retrieve: ");
                    int indexToGet = Integer.parseInt(sc.nextLine());
                    OrderForm orderForm = controller.getOrder(indexToGet);
                    if (orderForm != null) {
                        System.out.println("Customer ID: " + orderForm.getCustomerId());
                        System.out.println("Product ID: " + orderForm.getProductId());
                        System.out.println("Status: " + orderForm.getStatus());
                    } else {
                        System.out.println("Order not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Order Index to Cancel: ");
                    int indexToCancel = Integer.parseInt(sc.nextLine());
                    OrderForm cancelledOrder = controller.getOrder(indexToCancel);
                    if (cancelledOrder != null) {
                        controller.cancelOrder(indexToCancel);
                        historyController.addCompletedOrder(cancelledOrder);
                        System.out.println("Order cancelled and saved to history.");
                    } else {
                        System.out.println("Order not found.");
                    }
                    break;

                case 5:
                    List<OrderForm> completedOrders = historyController.getAllCompletedOrders();
                    System.out.println("--- Completed Orders ---");
                    if (completedOrders.isEmpty()) {
                        System.out.println("No completed orders found.");
                    } else {
                        for (OrderForm completed : completedOrders) {
                            System.out.println("Product ID: " + completed.getProductId()
                                    + ", Customer ID: " + completed.getCustomerId()
                                    + ", Status: " + completed.getStatus());
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting Order Management System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
