package com.jocata.ordermanagementsystem.service.imp;
import com.jocata.ordermanagementsystem.dao.InventoryDao;
import com.jocata.ordermanagementsystem.dao.imp.InventoryDaoImp;
import com.jocata.ordermanagementsystem.entity.InventoryEntity;
import com.jocata.ordermanagementsystem.form.InventoryForm;
import com.jocata.ordermanagementsystem.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {

    private InventoryDao inventoryDao = new InventoryDaoImp();

    @Override
    public String updateInventory(InventoryForm form) {
        InventoryEntity entity= new InventoryEntity();
        entity.setProductId(Integer.valueOf(form.getProductId()));
        entity.setStock(Integer.valueOf(form.getStock()));
        return inventoryDao.updateInventory(entity);
    }

    @Override
    public int getCurrentStock(Integer productId) {
        return inventoryDao.getCurrentStock(productId);
    }

    @Override
    public String reduceStock(Integer productId, Integer quantity) {
        return inventoryDao.reduceStock(productId, quantity);
    }

    @Override
    public InventoryEntity getInventory(Integer productId) {
        return inventoryDao.getInventory(productId);
    }
}
