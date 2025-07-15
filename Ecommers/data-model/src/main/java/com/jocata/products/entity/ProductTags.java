package com.jocata.products.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product_tags")
public class ProductTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tagName;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private Set<ProductTagRelation> productRelations = new HashSet<>();


    public Set<ProductTagRelation> getProductRelations() {
        return productRelations;
    }

    public void setProductRelations(Set<ProductTagRelation> productRelations) {
        this.productRelations = productRelations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
