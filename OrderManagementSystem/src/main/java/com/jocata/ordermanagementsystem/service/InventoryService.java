package com.jocata.ordermanagementsystem.service;

import com.jocata.ordermanagementsystem.entity.InventoryEntity;
import com.jocata.ordermanagementsystem.form.InventoryForm;

public interface InventoryService {
    String updateInventory(InventoryForm entity);
    int getCurrentStock(Integer productId);
    String reduceStock(Integer productId, Integer quantity);
    InventoryEntity getInventory(Integer productId);
}
