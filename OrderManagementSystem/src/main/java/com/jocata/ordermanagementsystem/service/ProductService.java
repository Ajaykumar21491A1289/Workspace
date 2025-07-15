package com.jocata.ordermanagementsystem.service;

import com.jocata.ordermanagementsystem.entity.ProductEntity;
import com.jocata.ordermanagementsystem.form.ProductForm;

import java.nio.file.Path;

public interface ProductService {
    String addProduct(ProductForm form);
    String updateProduct(ProductForm form);
    ProductForm getProduct(String productId);
    String deleteProduct(String productId);
}
