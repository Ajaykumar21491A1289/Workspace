package com.jocata.controller;

import com.jocata.products.entity.Products;
import com.jocata.products.forms.ProductForm;
import com.jocata.products.forms.ProductResForm;
import com.jocata.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductForm addProduct(@RequestBody @Valid ProductForm form) {
        return productService.addProduct(form);
    }

    @GetMapping("/{id}")
    public ProductResForm getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<ProductResForm> searchByName(@RequestParam String name) {
        return productService.searchProductsByName(name);
    }

}
