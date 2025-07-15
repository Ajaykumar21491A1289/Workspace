package com.jocata.dao.transaction;

import com.jocata.transaction.entity.PaymentMethos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethos, Long> {
}
