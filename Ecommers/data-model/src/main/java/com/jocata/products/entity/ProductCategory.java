package com.jocata.products.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product_categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<ProductCategoryRelation> productRelations = new HashSet<>();


    public Set<ProductCategoryRelation> getProductRelations() {
        return productRelations;
    }

    public void setProductRelations(Set<ProductCategoryRelation> productRelations) {
        this.productRelations = productRelations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
