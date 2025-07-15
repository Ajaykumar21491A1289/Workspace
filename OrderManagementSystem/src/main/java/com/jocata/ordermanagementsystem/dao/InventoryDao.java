package com.jocata.ordermanagementsystem.dao;

import com.jocata.ordermanagementsystem.entity.InventoryEntity;

public interface InventoryDao {
    public String updateInventory(InventoryEntity entity);
    public int getCurrentStock(Integer productId);
    public String reduceStock(Integer productId, Integer quantity);
    public InventoryEntity getInventory(Integer productId);

}
