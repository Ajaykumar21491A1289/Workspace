package com.jocata.dao.promotions;

import com.jocata.promotions.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    List<Discount> findByProductId(Long productId);
}
