package com.jocata.ordermanagement.inventoryManagement.service;

import com.jocata.ordermanagement.inventoryManagement.form.ProductForm;

import java.util.List;

public interface InventoryService {

    String addProduct(ProductForm productForm);
    String removeProduct(int productId);
    String updateProductDetails(ProductForm productForm);
    ProductForm getProductDetails(int productId);
    List<ProductForm> getAllProducts();
    String reduceStock(Integer productId,Integer quantity);
}
