package com.jocata.ordermanagementsystem.main;

import com.jocata.ordermanagementsystem.controller.InventoryController;
import com.jocata.ordermanagementsystem.entity.InventoryEntity;
import com.jocata.ordermanagementsystem.form.InventoryForm;

import java.util.Scanner;

public class InventoryMain {
    public static void main(String[] args) {
        InventoryController controller = new InventoryController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Inventory Menu ===");
            System.out.println("1. Add/Update Inventory");
            System.out.println("2. Get Current Stock");
            System.out.println("3. Reduce Stock");
            System.out.println("4. Get Inventory Details");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    InventoryForm form = new InventoryForm();
                    System.out.print("Enter Product ID: ");
                    form.setProductId(sc.next());
                    System.out.print("Enter Stock: ");
                    form.setStock(sc.next());
                    System.out.println(controller.updateInventory(form));
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int stockId = sc.nextInt();
                    int currentStock = controller.getCurrentStock(stockId);
                    System.out.println("Current Stock: " + currentStock);
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int reduceId = sc.nextInt();
                    System.out.print("Enter Quantity to Reduce: ");
                    int quantity = sc.nextInt();
                    System.out.println(controller.reduceStock(reduceId, quantity));
                    break;

                case 4:
                    System.out.print("Enter Product ID: ");
                    int getId = sc.nextInt();
                    InventoryEntity entity = controller.getInventory(getId);
                    if (entity != null) {
                        System.out.println("Product ID: " + entity.getProductId());
                        System.out.println("Stock: " + entity.getStock());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
