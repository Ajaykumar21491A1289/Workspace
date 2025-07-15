/*
package com.jocata.ordermanagement;

import com.jocata.ordermanagement.customermanagement.controller.CustomerController;
import com.jocata.ordermanagement.customermanagement.form.CustomerForm;
import com.jocata.ordermanagement.inventoryManagement.controller.InventoryController;
import com.jocata.ordermanagement.inventoryManagement.form.ProductForm;
import com.jocata.ordermanagement.ordermanager.controller.OrderController;
import com.jocata.ordermanagement.ordermanager.form.OrderForm;
import com.jocata.ordermanagement.payment.controller.PaymentController;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerController customerController = new CustomerController();
        InventoryController inventoryController = new InventoryController();
        OrderController orderController = new OrderController();
        PaymentController paymentController = new PaymentController();

        while (true) {
            System.out.println("\n==== Main Menu ====");
            System.out.println("1. Customer Management");
            System.out.println("2. Inventory Management");
            System.out.println("3. Order Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {
                case 1: // Customer
                    System.out.println("\n--- Customer Management ---");
                    System.out.println("1. Add Customer");
                    System.out.println("2. Update Customer");
                    System.out.println("3. Get Customer by ID");
                    System.out.println("4. Delete Customer");
                    System.out.print("Enter your choice: ");
                    int c = sc.nextInt();
                    sc.nextLine();
                    CustomerForm cform = new CustomerForm();
                    switch (c) {
                        case 1:
                            System.out.print("Enter Customer ID: ");
                            cform.setCustomerId(sc.nextLine());
                            System.out.print("Enter Name: ");
                            cform.setName(sc.nextLine());
                            System.out.print("Enter Email: ");
                            cform.setEmail(sc.nextLine());
                            System.out.print("Enter Address: ");
                            cform.setText(sc.nextLine());
                            System.out.println(customerController.addCustomer(cform));
                            break;
                        case 2:
                            System.out.print("Enter Customer ID: ");
                            cform.setCustomerId(sc.nextLine());
                            System.out.print("Enter Updated Name: ");
                            cform.setName(sc.nextLine());
                            System.out.print("Enter Updated Email: ");
                            cform.setEmail(sc.nextLine());
                            System.out.print("Enter Updated Address: ");
                            cform.setText(sc.nextLine());
                            System.out.println(customerController.updateCustomer(cform));
                            break;
                        case 3:
                            System.out.print("Enter Customer ID to Get: ");
                            int cid = sc.nextInt();
                            sc.nextLine();
                            CustomerForm retrieved = customerController.getCustomer(cid);
                            if (retrieved != null) {
                                System.out.println("ID: " + retrieved.getCustomerId());
                                System.out.println("Name: " + retrieved.getName());
                                System.out.println("Email: " + retrieved.getEmail());
                                System.out.println("Address: " + retrieved.getAddress());
                            } else {
                                System.out.println("Customer not found.");
                            }
                            break;
                        case 4:
                            System.out.print("Enter Customer ID to Delete: ");
                            int delId = sc.nextInt();
                            sc.nextLine();
                            System.out.println(customerController.deleteCustomer(delId));
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 2: // Inventory
                    System.out.println("\n--- Inventory Management ---");
                    System.out.println("1. Add Product");
                    System.out.println("2. Remove Product");
                    System.out.println("3. Update Product");
                    System.out.println("4. Get Product");
                    System.out.println("5. Get All Products");
                    System.out.print("Enter your choice: ");
                    int i = sc.nextInt();
                    sc.nextLine();
                    ProductForm pform = new ProductForm();
                    switch (i) {
                        case 1:
                            System.out.print("Enter Product ID: ");
                            pform.setProductId(sc.nextLine());
                            System.out.print("Enter Product Name: ");
                            pform.setProductName(sc.nextLine());
                            System.out.print("Enter Price: ");
                            pform.setPrice(sc.nextLine());
                            System.out.print("Enter Stock Quantity: ");
                            pform.setStockQuantity(sc.nextLine());
                            System.out.println(inventoryController.addProduct(pform));
                            break;
                        case 2:
                            System.out.print("Enter Product ID to Remove: ");
                            int pid = sc.nextInt();
                            sc.nextLine();
                            System.out.println(inventoryController.removeProduct(pid));
                            break;
                        case 3:
                            System.out.print("Enter Product ID: ");
                            pform.setProductId(sc.nextLine());
                            System.out.print("Enter Product Name: ");
                            pform.setProductName(sc.nextLine());
                            System.out.print("Enter Price: ");
                            pform.setPrice(sc.nextLine());
                            System.out.print("Enter Stock Quantity: ");
                            pform.setStockQuantity(sc.nextLine());
                            System.out.println(inventoryController.updateProductDetails(pform));
                            break;
                        case 4:
                            System.out.print("Enter Product ID to Get: ");
                            int getPid = sc.nextInt();
                            sc.nextLine();
                            ProductForm getProduct = inventoryController.getProductDetails(getPid);
                            if (getProduct != null) {
                                System.out.println("ID: " + getProduct.getProductId());
                                System.out.println("Name: " + getProduct.getProductName());
                                System.out.println("Price: " + getProduct.getPrice());
                                System.out.println("Stock: " + getProduct.getStockQuantity());
                            } else {
                                System.out.println("Product not found.");
                            }
                            break;
                        case 5:
                            List<ProductForm> products = inventoryController.getAllProducts();
                            for (ProductForm pf : products) {
                                System.out.println("ID: " + pf.getProductId() + ", Name: " + pf.getProductName()
                                        + ", Price: " + pf.getPrice() + ", Stock: " + pf.getStockQuantity());
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 3: // Orders
                    System.out.println("\n--- Order Management ---");
                    System.out.println("1. Add Order");
                    System.out.println("2. Update Order");
                    System.out.println("3. Cancel Order");
                    System.out.println("4. View All Orders");
                    System.out.print("Enter your choice: ");
                    int o = sc.nextInt();
                    sc.nextLine();
                    switch (o) {
                        case 1:
                        case 2:
                            OrderForm order = new OrderForm();
                            System.out.print("Enter Order ID: ");
                            order.setOrderId(sc.nextLine());
                            System.out.print("Enter Customer ID: ");
                            order.setCustomerId(sc.nextLine());
                            System.out.print("Enter Product IDs (comma separated): ");
                            String[] ids = sc.nextLine().split(",");
                            List<Integer> pidList = new ArrayList<>();
                            for (String pidStr : ids) {
                                int pid = Integer.parseInt(pidStr.trim());
                                pidList.add(pid);
                                System.out.print("Enter quantity for Product ID " + pid + ": ");
                                int qty = sc.nextInt();
                                sc.nextLine();
                                inventoryController.reduceStock(pid, qty);
                            }
                            order.setProductIds(pidList);
                            System.out.print("Enter Amount Paid: ");
                            int amount = sc.nextInt();
                            paymentController.setPayment(Integer.parseInt(order.getOrderId()), amount);
                            order.setStatus(paymentController.getPaymentStatus(Integer.parseInt(order.getOrderId())));
                            String result = (o == 1)
                                    ? orderController.addOrder(order)
                                    : orderController.updateOrder(order);
                            System.out.println(result);
                            break;
                        case 3:
                            System.out.print("Enter Order ID to Cancel: ");
                            int cancelId = sc.nextInt();
                            sc.nextLine();
                            System.out.println(orderController.cancleOrder(cancelId));
                            break;
                        case 4:
                            List<OrderForm> allOrders = orderController.getAllOrders();
                            for (OrderForm of : allOrders) {
                                System.out.println("Order ID: " + of.getOrderId() + ", Customer ID: " + of.getCustomerId()
                                        + ", Products: " + of.getProductIds() + ", Status: " + of.getStatus());
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the application.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
*/
