package com.jocata.ordermanagement.inventoryManagement.controller;

import com.jocata.ordermanagement.inventoryManagement.form.ProductForm;
import com.jocata.ordermanagement.inventoryManagement.service.InventoryService;
import com.jocata.ordermanagement.inventoryManagement.service.impl.InventoryServiceImpl;

import java.util.List;

public class InventoryController {

    InventoryService service = new InventoryServiceImpl();

    public String addProduct(ProductForm form) {
        if (form.getProductId() != null && !form.getProductId().isEmpty() &&
                form.getProductName() != null && !form.getProductName().isEmpty() &&
                form.getPrice() != null && !form.getPrice().isEmpty() &&
                form.getStockQuantity() != null && !form.getStockQuantity().isEmpty()) {
            return service.addProduct(form);

        }
        return " Validation Not Satisfied";
    }

        public String removeProduct(Integer productId){
            if(productId!=null){
                return service.removeProduct(productId);
            }
            return "Validation Not Satisfied";
        }

        public ProductForm getProductDetails(Integer productId){
            if(productId!=null){
                return service.getProductDetails(productId);
            }
            return null;
        }

        public List<ProductForm> getAllProducts(){
        return service.getAllProducts();

        }

        public String updateProductDetails(ProductForm form){
            if (form.getProductId() != null && !form.getProductId().isEmpty() &&
                    form.getProductName() != null && !form.getProductName().isEmpty() &&
                    form.getPrice() != null && !form.getPrice().isEmpty() &&
                    form.getStockQuantity() != null && !form.getStockQuantity().isEmpty()) {
                return service.updateProductDetails(form);

            }
            return "Validation Not Satisfied";
        }

    public String reduceStock(Integer productId,Integer quantity){
        return service.reduceStock(productId, quantity);
    }

    }

