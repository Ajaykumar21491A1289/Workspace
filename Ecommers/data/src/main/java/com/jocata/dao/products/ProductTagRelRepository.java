package com.jocata.dao.products;

import com.jocata.products.entity.ProductTagRelId;
import com.jocata.products.entity.ProductTagRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTagRelRepository extends JpaRepository<ProductTagRelation, ProductTagRelId> {}
