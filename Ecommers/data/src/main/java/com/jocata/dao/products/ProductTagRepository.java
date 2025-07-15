package com.jocata.dao.products;

import com.jocata.products.entity.ProductTags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTagRepository extends JpaRepository<ProductTags, Long> {}
