package com.jocata.ordermanagement.inventoryManagement.dao;

import com.jocata.ordermanagement.inventoryManagement.entity.ProductEntity;

import java.util.List;

public interface InventoryDao {

    String addProduct(ProductEntity productEntity);
    String removeProduct(int productId);
    String updateProductDetails(ProductEntity productEntity);
    ProductEntity getProductDetails(int productId);
    List<ProductEntity> getAllProducts();
    String reduceStock(Integer productId,Integer quantity);
}
