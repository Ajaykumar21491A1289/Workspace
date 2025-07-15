package com.jocata.ordermanagementsystem.dao;

import com.jocata.ordermanagementsystem.entity.ProductEntity;
import com.jocata.ordermanagementsystem.form.ProductForm;

import java.nio.file.Path;

public interface ProductDao {

    String addProduct(ProductEntity entity);
    String updateProduct(ProductEntity entity);
    ProductEntity getProduct(Integer productId);
    String deleteProduct(Integer productId);
}
