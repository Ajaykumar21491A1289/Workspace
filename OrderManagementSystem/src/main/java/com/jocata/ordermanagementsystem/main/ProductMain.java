package com.jocata.ordermanagementsystem.main;

import com.jocata.ordermanagementsystem.controller.ProductController;
import com.jocata.ordermanagementsystem.form.ProductForm;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductController controller = new ProductController();
        int choice;

        do {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Get Product by ID");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            ProductForm form = new ProductForm();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    form.setProductId(sc.nextLine());
                    System.out.print("Enter Product Name: ");
                    form.setProductName(sc.nextLine());
                    System.out.print("Enter Price: ");
                    form.setPrice(sc.nextLine());
                    System.out.print("Enter Stock Quantity: ");
                    form.setStockQuantity(sc.nextLine());
                    System.out.println(controller.addProduct(form));
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    form.setProductId(sc.nextLine());
                    System.out.print("Enter Updated Product Name: ");
                    form.setProductName(sc.nextLine());
                    System.out.print("Enter Updated Price: ");
                    form.setPrice(sc.nextLine());
                    System.out.print("Enter Updated Stock Quantity: ");
                    form.setStockQuantity(sc.nextLine());
                    System.out.println(controller.updateProduct(form));
                    break;

                case 3:
                    System.out.print("Enter Product ID to Retrieve: ");
                    String productIdToGet = sc.nextLine();
                    ProductForm retrieved = controller.getProduct(productIdToGet);
                    if (retrieved != null) {
                        System.out.println("Product ID: " + retrieved.getProductId());
                        System.out.println("Product Name: " + retrieved.getProductName());
                        System.out.println("Price: " + retrieved.getPrice());
                        System.out.println("Stock Quantity: " + retrieved.getStockQuantity());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to Delete: ");
                    String productIdToDelete = sc.nextLine();
                    System.out.println(controller.getdeleteProduct(productIdToDelete));
                    break;

                case 5:
                    System.out.println("Exiting Product Management System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
