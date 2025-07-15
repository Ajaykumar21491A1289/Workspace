package com.jocata.ordermanagement.inventoryManagement.main;

import com.jocata.ordermanagement.inventoryManagement.controller.InventoryController;
import com.jocata.ordermanagement.inventoryManagement.dao.InventoryDao;
import com.jocata.ordermanagement.inventoryManagement.dao.impl.InventoryDaoImpl;
import com.jocata.ordermanagement.inventoryManagement.form.ProductForm;

import java.util.List;
import java.util.Scanner;

public class InventoryMain {
    public static void main(String[] args) {
        InventoryController controller = new InventoryController();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Inventory Management ===");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. Get Product Details");
            System.out.println("5. Get All Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1: // Add Product
                    ProductForm addForm = new ProductForm();
                    System.out.print("Enter Product ID: ");
                    addForm.setProductId(scanner.nextLine());
                    System.out.print("Enter Product Name: ");
                    addForm.setProductName(scanner.nextLine());
                    System.out.print("Enter Price: ");
                    addForm.setPrice(scanner.nextLine());
                    System.out.print("Enter Stock Quantity: ");
                    addForm.setStockQuantity(scanner.nextLine());

                    String addResult = controller.addProduct(addForm);
                    System.out.println(addResult);
                    break;

                case 2: // Remove Product
                    System.out.print("Enter Product ID to Remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();  // consume newline

                    String removeResult = controller.removeProduct(removeId);
                    System.out.println(removeResult);
                    break;

                case 3: // Update Product
                    ProductForm updateForm = new ProductForm();
                    System.out.print("Enter Product ID: ");
                    updateForm.setProductId(scanner.nextLine());
                    System.out.print("Enter Product Name: ");
                    updateForm.setProductName(scanner.nextLine());
                    System.out.print("Enter Price: ");
                    updateForm.setPrice(scanner.nextLine());
                    System.out.print("Enter Stock Quantity: ");
                    updateForm.setStockQuantity(scanner.nextLine());

                    String updateResult = controller.updateProductDetails(updateForm);
                    System.out.println(updateResult);
                    break;

                case 4: // Get Product Details
                    System.out.print("Enter Product ID to View: ");
                    int viewId = scanner.nextInt();
                    scanner.nextLine();  // consume newline

                    ProductForm productDetails = controller.getProductDetails(viewId);
                    if (productDetails != null) {
                        System.out.println("Product ID: " + productDetails.getProductId());
                        System.out.println("Product Name: " + productDetails.getProductName());
                        System.out.println("Price: " + productDetails.getPrice());
                        System.out.println("Stock Quantity: " + productDetails.getStockQuantity());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5: // Get All Products
                    List<ProductForm> products = controller.getAllProducts();
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        for (ProductForm product : products) {
                            System.out.println("------------------------------");
                            System.out.println("Product ID: " + product.getProductId());
                            System.out.println("Product Name: " + product.getProductName());
                            System.out.println("Price: " + product.getPrice());
                            System.out.println("Stock Quantity: " + product.getStockQuantity());
                        }
                        System.out.println("------------------------------");
                    }
                    break;


                case 6: // Exit
                    exit = true;
                    System.out.println("Exiting Inventory Management. Goodbye!");
                    break;



                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
