package com.jocata.ordermanagementsystem.service.imp;

import com.jocata.ordermanagementsystem.dao.InventoryDao;
import com.jocata.ordermanagementsystem.dao.ProductDao;
import com.jocata.ordermanagementsystem.dao.imp.InventoryDaoImp;
import com.jocata.ordermanagementsystem.dao.imp.ProductDaoImp;
import com.jocata.ordermanagementsystem.entity.InventoryEntity;
import com.jocata.ordermanagementsystem.entity.ProductEntity;
import com.jocata.ordermanagementsystem.form.ProductForm;
import com.jocata.ordermanagementsystem.service.ProductService;

import java.nio.file.Path;

public class ProductServiceImp implements ProductService {

    ProductDao dao = new ProductDaoImp();
    InventoryDao inventoryDao = new InventoryDaoImp();
    InventoryEntity inventoryEntity = new InventoryEntity();


    private ProductEntity addDetails(ProductForm form){
        ProductEntity entity = new ProductEntity();
        entity.setProductId(Integer.parseInt(form.getProductId()));
        entity.setProductName(form.getProductName());
        entity.setPrice(Integer.parseInt(form.getPrice()));
        return entity;

    }

    @Override
    public String addProduct(ProductForm form) {
        inventoryEntity.setStock(Integer.valueOf(form.getStockQuantity()));
        inventoryEntity.setProductId(Integer.parseInt(form.getProductId()));
        inventoryDao.updateInventory(inventoryEntity);
        return dao.addProduct(addDetails(form));
    }

    @Override
    public String updateProduct(ProductForm form) {
        inventoryEntity.setStock(Integer.valueOf(form.getStockQuantity()));
        inventoryEntity.setProductId(Integer.parseInt(form.getProductId()));
        inventoryDao.updateInventory(inventoryEntity);
        return dao.updateProduct(addDetails(form));
    }

    @Override
    public ProductForm getProduct(String productId) {
        ProductEntity entity = dao.getProduct(Integer.parseInt(productId));
        Integer stock = inventoryDao.getCurrentStock(Integer.parseInt(productId));
        ProductForm form = new ProductForm();
        form.setProductId(String.valueOf(entity.getProductId()));
        form.setProductName(entity.getProductName());
        form.setPrice(String.valueOf(entity.getPrice()));
        form.setStockQuantity(String.valueOf(stock));
        return form;


    }

    @Override
    public String deleteProduct(String productId) {
        return dao.deleteProduct(Integer.parseInt(productId));
    }
}
