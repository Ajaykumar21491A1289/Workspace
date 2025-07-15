package com.jocata.service;

import com.jocata.products.entity.Products;
import com.jocata.products.forms.ProductForm;
import com.jocata.products.forms.ProductResForm;

import java.util.List;

public interface ProductService {

    ProductForm addProduct(ProductForm form);
    ProductResForm getProductById(Long id);
    List<ProductResForm> searchProductsByName(String name);
}
