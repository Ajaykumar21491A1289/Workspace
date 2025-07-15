package com.jocata.service.impl;

import com.jocata.dao.inventory.InventoryRepository;
import com.jocata.dao.inventory.StockMovementRepository;
import com.jocata.dao.inventory.SupplierRepository;
import com.jocata.inventory.MovementType;
import com.jocata.inventory.entity.Inventory;
import com.jocata.inventory.entity.StockMovement;
import com.jocata.inventory.entity.Supplier;
import com.jocata.products.forms.ProductForm;
import com.jocata.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepo;

    @Autowired
    private SupplierRepository supplierRepo;

    @Autowired
    private StockMovementRepository stockRepo;

    @Override
    public void createInventoryAndStock(ProductForm request) {
        Supplier supplier = createSupplier(request);
        Inventory inventory = createInventory(request);
        createStockMovement(request, supplier);
    }

    private Supplier createSupplier(ProductForm request) {
        Supplier supplier = new Supplier();
        supplier.setName(request.getSupplierName());
        supplier.setContactInfo(request.getContactInfo());
        return supplierRepo.save(supplier);
    }

    private Inventory createInventory(ProductForm request) {
        Inventory inventory = new Inventory();
        inventory.setProductId(request.getProductId());
        inventory.setQuantity(request.getQuantity());
        return inventoryRepo.save(inventory);
    }

    private void createStockMovement(ProductForm request, Supplier supplier) {
        StockMovement stock = new StockMovement();
        stock.setProductId(request.getProductId());
        stock.setQuantity(request.getStockQuantity());
        stock.setSupplier(supplier);
        stock.setMovementType(MovementType.valueOf(request.getMovementType()));
        stockRepo.save(stock);
    }

    @Override
    public Integer reduceStock(Long productId, int requestedQty) {
        Optional<Inventory> optionalInventory = inventoryRepo.findByProductId(productId);
        if (optionalInventory.isEmpty()) {
            throw new IllegalStateException("Product not found in inventory with ID: " + productId);
        }

        Inventory inventory = optionalInventory.get();
        if (inventory.getQuantity() < requestedQty) {
            throw new IllegalStateException("Insufficient stock for product ID: " + productId);
        }

        int updatedRows = inventoryRepo.reduceQuantity(productId, requestedQty);
        if (updatedRows == 0) {
            throw new IllegalStateException("Failed to reduce stock for product ID: " + productId);
        }
        return 1;
    }

    @Override
    public Integer getAvailableQuantity(Long productId) {
        return inventoryRepo.findByProductId(productId)
                .map(Inventory::getQuantity)
                .orElse(0); // or throw exception if preferred
    }

}
