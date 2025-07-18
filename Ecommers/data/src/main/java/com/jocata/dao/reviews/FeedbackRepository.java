package com.jocata.dao.reviews;

import com.jocata.reviews_ratings.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack, Long> {
    List<FeedBack> findByProductId(Long productId);
}