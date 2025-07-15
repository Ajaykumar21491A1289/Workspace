package com.jocata.service;

import com.jocata.products.forms.ProductForm;

public interface InventoryService {
    void createInventoryAndStock(ProductForm request);
    Integer reduceStock(Long productId, int requestedQty);

    Integer getAvailableQuantity(Long productId);
}
