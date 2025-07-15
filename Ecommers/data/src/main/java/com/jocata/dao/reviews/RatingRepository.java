package com.jocata.dao.reviews;

import com.jocata.reviews_ratings.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, Long> {
    List<Ratings> findByProductId(Long productId);
}