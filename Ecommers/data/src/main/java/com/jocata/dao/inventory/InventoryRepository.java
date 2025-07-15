package com.jocata.dao.inventory;

import com.jocata.inventory.entity.Inventory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Inventory i SET i.quantity = i.quantity - :requestedQty WHERE i.productId = :productId AND i.quantity >= :requestedQty")
    int reduceQuantity(Long productId, Integer requestedQty);

    Optional<Inventory> findByProductId(Long productId);
}
