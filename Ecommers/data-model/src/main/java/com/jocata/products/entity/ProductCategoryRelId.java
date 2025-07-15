package com.jocata.products.entity;

import java.io.Serial;
import java.io.Serializable;

public class ProductCategoryRelId implements Serializable {

    private Long productId;
    private Long categoryId;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
