package com.jocata.dao.promotions;

import com.jocata.promotions.entity.Coupn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupn, Long> {
    Optional<Coupn> findByCode(String code);
}