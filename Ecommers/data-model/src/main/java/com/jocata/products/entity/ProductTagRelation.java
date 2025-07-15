package com.jocata.products.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "product_tag_rel")
public class ProductTagRelation{

    @EmbeddedId
    private ProductTagRelId id;

    @JsonBackReference("product-tag")
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Products product;

    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private ProductTags tag;

    public ProductTagRelId getId() {
        return id;
    }

    public void setId(ProductTagRelId id) {
        this.id = id;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public ProductTags getTag() {
        return tag;
    }

    public void setTag(ProductTags tag) {
        this.tag = tag;
    }
}