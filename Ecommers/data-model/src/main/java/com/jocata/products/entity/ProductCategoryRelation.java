package com.jocata.products.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="product_category_rel")
public class ProductCategoryRelation {

    @EmbeddedId
    private ProductCategoryRelId id;

    @JsonBackReference("product-category")
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Products product;


    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    public ProductCategoryRelId getId() {
        return id;
    }

    public void setId(ProductCategoryRelId id) {
        this.id = id;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
