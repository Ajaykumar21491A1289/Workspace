package com.jocata.products.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;


    @JsonManagedReference
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private ProductDetails productDetails;


    @JsonManagedReference("product-category")
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductCategoryRelation> categoryRelations = new HashSet<>();


    @JsonManagedReference("product-tag")
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductTagRelation> tagRelations = new HashSet<>();


    public Set<ProductCategoryRelation> getCategoryRelations() {
        return categoryRelations;
    }

    public void setCategoryRelations(Set<ProductCategoryRelation> categoryRelations) {
        this.categoryRelations = categoryRelations;
    }

    public Set<ProductTagRelation> getTagRelations() {
        return tagRelations;
    }

    public void setTagRelations(Set<ProductTagRelation> tagRelations) {
        this.tagRelations = tagRelations;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
