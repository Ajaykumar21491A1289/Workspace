package com.jocata.dao.products;

import com.jocata.products.entity.ProductCategoryRelId;
import com.jocata.products.entity.ProductCategoryRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRelRepository extends JpaRepository<ProductCategoryRelation, ProductCategoryRelId> {}
