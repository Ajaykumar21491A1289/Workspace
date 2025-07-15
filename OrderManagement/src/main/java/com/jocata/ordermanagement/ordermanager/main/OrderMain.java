package com.jocata.ordermanagement.ordermanager.main;

import com.jocata.ordermanagement.history.controller.HistoryController;
import com.jocata.ordermanagement.inventoryManagement.controller.InventoryController;
import com.jocata.ordermanagement.inventoryManagement.service.InventoryService;
import com.jocata.ordermanagement.ordermanager.controller.OrderController;
import com.jocata.ordermanagement.ordermanager.entity.OrderEntity;
import com.jocata.ordermanagement.ordermanager.form.OrderForm;
import com.jocata.ordermanagement.payment.controller.PaymentController;

import java.util.*;

public class OrderMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderController controller = new OrderController();
        PaymentController paymentController = new PaymentController();
        InventoryController inventoryController = new InventoryController();
        HistoryController historyController = new HistoryController();
        while (true) {
            System.out.println("\n----- Order Management Menu -----");
            System.out.println("1. Add Order");
            System.out.println("2. Update Order");
            System.out.println("3. Cancel Order");
            System.out.println("4. View All Orders");
            System.out.println("5. View One Order");
            System.out.println("6. View Completed Orders");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    OrderForm newOrder = new OrderForm();

                    System.out.print("Enter Order ID: ");
                    newOrder.setOrderId(sc.nextLine());

                    System.out.print("Enter Customer ID: ");
                    newOrder.setCustomerId(sc.nextLine());

                    System.out.print("Enter Product IDs (comma separated): ");
                    String[] productStrings = sc.nextLine().split(",");
                    List<Integer> productIds = new ArrayList<>();
                    Map<Integer, Integer> quantityMap = new HashMap<>();

                    for (String s : productStrings) {
                        int pid = Integer.parseInt(s.trim());
                        productIds.add(pid);

                        // Take quantity for each product
                        System.out.print("Enter quantity for Product ID " + pid + ": ");
                        int qty = sc.nextInt();
                        sc.nextLine(); // consume newline
                        quantityMap.put(pid, qty);
                    }

                    newOrder.setProductIds(productIds);

                    System.out.print("Enter the Amount: ");
                    Integer amountPaid = sc.nextInt();

                    // Set payment
                    paymentController.setPayment(Integer.valueOf(newOrder.getOrderId()), productIds, amountPaid);

                    // Check payment status
                    String status = paymentController.getPaymentStatus(Integer.parseInt(newOrder.getOrderId()));
                    newOrder.setStatus(status);

                    // Reduce stock only if payment is PAID
                    if ("PAID".equalsIgnoreCase(status)) {
                        for (Map.Entry<Integer, Integer> entry : quantityMap.entrySet()) {
                            int pid = entry.getKey();
                            int qty = entry.getValue();
                            String stockStatus = inventoryController.reduceStock(pid, qty);
                            System.out.println(stockStatus);
                        }
                    } else {
                        System.out.println("Payment not complete. Stock will not be reduced.");
                    }

                    System.out.println(controller.addOrder(newOrder));
                    break;


                case 2:
                    OrderForm updateOrder = new OrderForm();
                    System.out.print("Enter Order ID to update: ");
                    updateOrder.setOrderId(sc.nextLine());

                    System.out.print("Enter Customer ID: ");
                    updateOrder.setCustomerId(sc.nextLine());

                    System.out.print("Enter Product IDs (comma separated): ");
                    String[] updateProductStrings = sc.nextLine().split(",");
                    List<Integer> updateProductIds = new ArrayList<>();
                    for (String s : updateProductStrings) {
                        int pid = Integer.parseInt(s.trim());
                        updateProductIds.add(pid);

                        // Ask for updated quantity and adjust stock
                        System.out.print("Enter new quantity for Product ID " + pid + ": ");
                        int qty = sc.nextInt();
                        sc.nextLine(); // consume newline
                        String stockStatus = inventoryController.reduceStock(pid, qty);
                        System.out.println(stockStatus);
                    }
                    updateOrder.setProductIds(updateProductIds);

                    System.out.print("Enter the new Amount Paid: ");
                    int amountPay = sc.nextInt();
                    paymentController.setPayment(Integer.valueOf(updateOrder.getOrderId()),updateOrder.getProductIds(), amountPay);
                    updateOrder.setStatus(paymentController.getPaymentStatus(Integer.parseInt(updateOrder.getOrderId())));

                    System.out.println(controller.updateOrder(updateOrder));
                    break;

                case 3:
                    System.out.print("Enter Order ID to cancel: ");
                    int cancelId = sc.nextInt();
                    System.out.println(controller.cancleOrder(cancelId));
                    break;

                case 4:
                    List<OrderForm> allOrders = controller.getAllOrders();
                    if (allOrders.isEmpty()) {
                        System.out.println("No orders found.");
                    } else {
                        for (OrderForm order : allOrders) {
                            System.out.println(order.getOrderId()+" "+order.getCustomerId()+" "+order.getProductIds()+" "+order.getStatus());
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter Order ID to view: ");
                    int orderId = sc.nextInt();
                    OrderForm form = controller.getOrder(orderId);
                    if (form != null) {
                        System.out.println(form.getOrderId()+" ,"+form.getCustomerId()+" ,"+form.getProductIds()+" ,"+form.getStatus());
                    } else {
                        System.out.println("Order not found.");
                    }
                    break;

                case 6:
                    List<OrderEntity> completedOrders = historyController.getCompletedOrders();
                    if (completedOrders.isEmpty()) {
                        System.out.println("No completed orders found.");
                    } else {
                        for (OrderEntity order : completedOrders) {
                            System.out.println("Order ID: " + order.getOrderId() +
                                    ", Customer ID: " + order.getCustomerId() +
                                    ", Products: " + order.getProductIds() +
                                    ", Status: " + order.getStatus());
                        }
                    }
                   break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
