package com.jocata.products.entity;

import java.io.Serializable;

public class ProductTagRelId implements Serializable {

    private Long productId;
    private Long tagId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
