package com.jocata.ordermanagement.inventoryManagement.service.impl;

import com.jocata.ordermanagement.inventoryManagement.dao.InventoryDao;
import com.jocata.ordermanagement.inventoryManagement.dao.impl.InventoryDaoImpl;
import com.jocata.ordermanagement.inventoryManagement.entity.ProductEntity;
import com.jocata.ordermanagement.inventoryManagement.form.ProductForm;
import com.jocata.ordermanagement.inventoryManagement.service.InventoryService;

import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {

    InventoryDao dao = new InventoryDaoImpl();



    public ProductEntity addDetailsToEntity(ProductForm form){
        ProductEntity entity = new ProductEntity();
        entity.setProductId(Integer.parseInt(form.getProductId()));
        entity.setProductName(form.getProductName());
        entity.setPrice(Double.parseDouble(form.getPrice()));
        entity.setStockQuantity(Integer.parseInt(form.getStockQuantity()));
        return entity;

    }

    public ProductForm addDetailsToForm(ProductEntity entity){
        ProductForm form = new ProductForm();
        form.setProductId(String.valueOf(entity.getProductId()));
        form.setProductName(entity.getProductName());
        form.setPrice(String.valueOf(entity.getPrice()));
        form.setStockQuantity(String.valueOf(entity.getStockQuantity()));
        return form;

    }
    @Override
    public String addProduct(ProductForm form) {

        return dao.addProduct(addDetailsToEntity(form));
    }

    @Override
    public String removeProduct(int productId) {
        return dao.removeProduct(productId);
    }

    @Override
    public String updateProductDetails(ProductForm form) {
        ProductForm res = getProductDetails(Integer.parseInt(form.getProductId()));
        if(res!=null){
            return dao.updateProductDetails(addDetailsToEntity(form));
        }
        return "product not found";
    }

    @Override
    public ProductForm getProductDetails(int productId) {
        return addDetailsToForm(dao.getProductDetails(productId));

    }

    @Override
    public List<ProductForm> getAllProducts() {
        List<ProductForm> forms =new ArrayList<>();
        List<ProductEntity> entityList = dao.getAllProducts();
        for(ProductEntity entity :entityList ){
            forms.add(addDetailsToForm(entity));
        }
        return forms;
    }

    public String reduceStock(Integer productId,Integer quantity){
        return dao.reduceStock(productId, quantity);
    }
}
