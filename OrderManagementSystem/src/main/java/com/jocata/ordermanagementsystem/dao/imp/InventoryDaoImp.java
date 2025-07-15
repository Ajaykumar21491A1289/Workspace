package com.jocata.ordermanagementsystem.dao.imp;

import com.jocata.ordermanagementsystem.dao.InventoryDao;
import com.jocata.ordermanagementsystem.entity.InventoryEntity;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class InventoryDaoImp implements InventoryDao{

    private final Path path = Paths.get("D:\\\\Notes\\\\inventoryData.txt");
    private Map<Integer, InventoryEntity> map = new HashMap<>();

    public InventoryDaoImp(){
        loadInventory();

    }


    public String updateInventory(InventoryEntity entity){
        map.put(entity.getProductId(),entity);
        saveInventory();
        return " Inventory Updated";
    }

    public int getCurrentStock(Integer productId){
        InventoryEntity entity = map.get(productId);
        return (entity!=null) ? entity.getStock() : 0;
    }
    public String reduceStock(Integer productId, Integer quantity){
        InventoryEntity entity = map.get(productId);
        if(entity == null){
            return "Product Not Found in inventory";
        }
        if(entity.getStock()> quantity){
            entity.setStock(entity.getStock()-quantity);
            updateInventory(entity);
            return "Stock reduced Successfully";
        }
        return "reduce Stock";
    }

    public InventoryEntity getInventory(Integer productId){
        return map.get(productId);
    }

    private void saveInventory(){
        try(ObjectOutputStream oos =new ObjectOutputStream(Files.newOutputStream(path))){
            oos.writeObject(map);
        }catch(IOException e){
            throw new RuntimeException("Failed to save data");
        }
    }


    public void loadInventory(){
        if(!Files.exists(path)){
            try{
                Files.createFile(path);
            }catch (IOException e){
                throw new RuntimeException("Failes to Create Product FIle");
            }
        }

        try(ObjectInputStream ois =new ObjectInputStream(Files.newInputStream(path))){
            map = (Map<Integer,InventoryEntity>) ois.readObject();
        }catch (EOFException e){
            map= new HashMap<>();
        }catch(IOException | ClassNotFoundException e){
            throw new RuntimeException("Failed to load data");
        }
    }


}
