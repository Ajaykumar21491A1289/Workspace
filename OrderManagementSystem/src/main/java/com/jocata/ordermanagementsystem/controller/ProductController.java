package com.jocata.ordermanagementsystem.controller;

import com.jocata.ordermanagementsystem.dao.ProductDao;
import com.jocata.ordermanagementsystem.entity.ProductEntity;
import com.jocata.ordermanagementsystem.form.ProductForm;
import com.jocata.ordermanagementsystem.service.ProductService;
import com.jocata.ordermanagementsystem.service.imp.ProductServiceImp;

import java.nio.file.Path;

public class ProductController {

    ProductService service = new ProductServiceImp();

    public String addProduct(ProductForm form){
        if (form.getProductId() != null && !form.getProductId().isEmpty() &&
                form.getProductName() != null && !form.getProductName().isEmpty()) {
            return service.addProduct(form);
        }
        return "Validation Failed";


    }
    public String updateProduct(ProductForm form){

        if (form.getProductId() != null && !form.getProductId().isEmpty() &&
                form.getProductName() != null && !form.getProductName().isEmpty()) {
            return service.updateProduct(form);
        }
        return "Validation Failed";

    }

    public ProductForm getProduct(String productId){
        if(productId!=null && !productId.isEmpty()){
            return service.getProduct(productId);
        }
        return null;

    }
    public String getdeleteProduct(String productId){
        if(productId!=null && !productId.isEmpty()){
            return service.deleteProduct(productId);
        }
        return "Validation Failed";
    }
}
