package com.jocata.ordermanagementsystem.dao.imp;

import com.jocata.ordermanagementsystem.dao.ProductDao;
import com.jocata.ordermanagementsystem.entity.ProductEntity;
import com.jocata.ordermanagementsystem.form.ProductForm;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class ProductDaoImp implements ProductDao {

    private Map<Integer,ProductEntity> productMap;
    private Path path = Paths.get("D:\\\\Notes\\\\productObject.txt");

    public ProductDaoImp(){
        this.productMap =loadProductData();
    }
    public String addProduct(ProductEntity entity){
        productMap.put(entity.getProductId(),entity);
        saveProduct();
        return " Product Added Successfully";

    }

    public String updateProduct(ProductEntity entity){
        if(productMap.containsKey(entity.getProductId())){
            productMap.put(entity.getProductId(),entity);
            saveProduct();
            return " Product Updated Successfully";
        }
        return "Product Not Found";
    }

    @Override
    public ProductEntity getProduct(Integer productId) {
        return productMap.get(productId);
    }

    @Override
    public String deleteProduct(Integer productId) {
        if(productMap.remove(productId)!=null){
            saveProduct();
            return " Product Deleted Successfully";
        }
        return "Product Not Deleted";
    }



    private void saveProduct(){
        try(ObjectOutputStream oos = new ObjectOutputStream((Files.newOutputStream(path)))){
            oos.writeObject(productMap);
        } catch(IOException e){
            throw new RuntimeException(" Failed to save product to file");
        }
    }


    private Map<Integer,ProductEntity> loadProductData(){
        if(!Files.exists(path)){
            try{
                Files.createFile(path);
                return new HashMap<>();
            } catch (IOException e){
                throw new RuntimeException("Failed to create product File");
            }
        }

        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))){
            return (Map<Integer, ProductEntity>) ois.readObject();
        }catch(EOFException e){
            return new HashMap<>();
        }catch (IOException | ClassNotFoundException e){
            throw new RuntimeException("Failed to Load data");
        }
    }


    /*private Path writeProduct(ProductEntity product){
        Path outputPath = Paths.get("D:\\Notes\\productOutput.txt");
        try(BufferedWriter writer =Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE)){
            writer.write(product.getProductId()+","+
                    product.getProductName()+","+
                    product.getPrice()+","+
                    product.getStockQuantity());
        } catch(IOException e){
            throw new RuntimeException(" Failed to wite data");
        }
        return outputPath;
    }*/

}
