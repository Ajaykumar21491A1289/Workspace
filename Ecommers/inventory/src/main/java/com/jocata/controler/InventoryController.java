package com.jocata.controler;

import com.jocata.products.forms.ProductForm;
import com.jocata.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<?> createInventory(@RequestBody ProductForm request) {
        inventoryService.createInventoryAndStock(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/reduceStock/{productId}/{requestedQty}")
    public ResponseEntity<?> reduceStock(@PathVariable Long productId,@PathVariable int requestedQty) {
       inventoryService.reduceStock(productId,requestedQty);
       return ResponseEntity.ok().build();
    }

    @GetMapping("/product/{productId}/quantity")
    public int getAvailableQuantity(@PathVariable Long productId) {
        return inventoryService.getAvailableQuantity(productId);
    }


}
