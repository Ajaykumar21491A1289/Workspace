package com.jocata.ordermanagement.inventoryManagement.dao.impl;

import com.jocata.ordermanagement.inventoryManagement.dao.InventoryDao;
import com.jocata.ordermanagement.inventoryManagement.entity.ProductEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryDaoImpl implements InventoryDao {

    Map<Integer,ProductEntity> products = new HashMap<>();
    private Path path = Paths.get("D:\\Files\\productObject.txt");

    public InventoryDaoImpl(){
        this.products =loadProductData();
    }

    @Override
    public String addProduct(ProductEntity entity) {
        products.put(entity.getProductId(),entity);
        saveProduct();
        return "Product Added Successfully";
    }

    @Override
    public String removeProduct(int productId) {
        if(products.remove(productId)!=null){
            saveProduct();
            return " Product Deleted Successfully";
        }
        return "Product Not Deleted";
    }

    @Override
    public String updateProductDetails(ProductEntity entity) {
        if(products.containsKey(entity.getProductId())){
            products.put(entity.getProductId(), entity);
            saveProduct();
            return "Product Updated Successfully";
        }
        return " Product Not FOund";
    }

    @Override
    public ProductEntity getProductDetails(int productId) {
        return products.get(productId);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public String reduceStock(Integer productId,Integer quantity) {
        ProductEntity entity = products.get(productId);
        entity.setStockQuantity(entity.getStockQuantity()-quantity);
        saveProduct();
        return " Stock Reduced Successfully";
    }


    private void saveProduct() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace(); // for debugging
            throw new RuntimeException("Failed to save Data To File", e);
        }
    }


    private Map<Integer, ProductEntity> loadProductData() {
        if (!Files.exists(path)) return new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            return (Map<Integer, ProductEntity>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // or log it
            return new HashMap<>();
        }
    }




}
