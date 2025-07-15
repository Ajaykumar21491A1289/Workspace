package com.jocata.service.impl;

import com.jocata.dao.products.*;
import com.jocata.products.entity.*;
import com.jocata.products.forms.ProductForm;
import com.jocata.products.forms.ProductResForm;
import com.jocata.service.ProductService;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private ProductCategoryRepository categoryRepo;
    @Autowired
    private ProductCategoryRelRepository categoryRelRepo;
    @Autowired
    private ProductTagRepository tagRepo;
    @Autowired
    private ProductTagRelRepository tagRelRepo;
    @Autowired
    private ProductDetailsRepository detailsRepo;


    @Transactional
    @Override
    public ProductForm addProduct(ProductForm form) {
        Products product = createProduct(form);
        saveProductDetails(form, product);
        assignCategories(form.getCategoryIds(), product);
        assignTags(form.getTagIds(), product);

        form.setProductId(product.getId());

        ResponseEntity<Void> response = restTemplate.postForEntity("http://localhost:8084/inventory", form, Void.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            form.setMessage("Records Inserted Successfully");
        } else {
            form.setMessage("Failed to insert records in the Inventory");
        }

        return form;

    }

    private void assignTags(List<Long> tagIds, Products product) {
        for (Long tagId : tagIds) {
            ProductTags tag = tagRepo.findById(tagId).orElseThrow();
            ProductTagRelation relation = new ProductTagRelation();
            ProductTagRelId relId = new ProductTagRelId();
            relId.setProductId(product.getId());
            relId.setTagId(tag.getId());
            relation.setId(relId);
            relation.setProduct(product);
            relation.setTag(tag);
            tagRelRepo.save(relation);
        }
    }

    private void assignCategories(List<Long> categoryIds, Products product) {
        for (Long catId : categoryIds) {
            ProductCategory category = categoryRepo.findById(catId).orElseThrow();
            ProductCategoryRelation relation = new ProductCategoryRelation();
            ProductCategoryRelId relId = new ProductCategoryRelId();
            relId.setProductId(product.getId());
            relId.setCategoryId(category.getId());
            relation.setId(relId);
            relation.setProduct(product);
            relation.setCategory(category);
            categoryRelRepo.save(relation);
        }
    }

    private void saveProductDetails(ProductForm form, Products product) {
        ProductDetails details = new ProductDetails();
        details.setProduct(product);
        details.setWeight(form.getWeight());
        details.setDimensions(form.getDimensions());
        details.setColor(form.getColor());
        detailsRepo.save(details);

    }

    private Products createProduct(ProductForm form) {

        Products product = new Products();
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());
        return productRepo.save(product);
    }

    @Override
    public ProductResForm getProductById(Long id) {
        Products product = productRepo.findById(id).orElse(null);
        ProductResForm dto = new ProductResForm();

        if(product!=null) {


            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setDescription(product.getDescription());
            dto.setPrice(product.getPrice());

            List<String> categoryNames = new ArrayList<>();
            for (ProductCategoryRelation rel : product.getCategoryRelations()) {
                categoryNames.add(rel.getCategory().getCategoryName());
            }
            dto.setCategories(categoryNames);

            List<String> tagNames = new ArrayList<>();
            for (ProductTagRelation rel : product.getTagRelations()) {
                tagNames.add(rel.getTag().getTagName());
            }
            dto.setTags(tagNames);

            ProductDetails details = product.getProductDetails();
            if (details != null) {
                dto.setWeight(details.getWeight());
                dto.setDimensions(details.getDimensions());
                dto.setColor(details.getColor());
            }
            return dto;
        }
        dto.setMessage("Product Not Found");
       return dto;

    }

    @Override
    public List<ProductResForm> searchProductsByName(String name) {
        List<Products> products = productRepo.findByNameContainingIgnoreCase(name);
        List<ProductResForm> result = new ArrayList<>();

            for (Products product : products) {
                ProductResForm dto = new ProductResForm();
                dto.setId(product.getId());
                dto.setName(product.getName());
                dto.setDescription(product.getDescription());
                dto.setPrice(product.getPrice());

                List<String> categoryNames = new ArrayList<>();
                for (ProductCategoryRelation rel : product.getCategoryRelations()) {
                    categoryNames.add(rel.getCategory().getCategoryName());
                }
                dto.setCategories(categoryNames);

                List<String> tagNames = new ArrayList<>();
                for (ProductTagRelation rel : product.getTagRelations()) {
                    tagNames.add(rel.getTag().getTagName());
                }
                dto.setTags(tagNames);

                ProductDetails details = product.getProductDetails();
                if (details != null) {
                    dto.setWeight(details.getWeight());
                    dto.setDimensions(details.getDimensions());
                    dto.setColor(details.getColor());
                }

                result.add(dto);
            }
            return result;
    }
}
