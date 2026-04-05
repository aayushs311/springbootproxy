package com.example.productservice.service;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    void updateProduct(long productId, Product product);
    Product updatePartialProduct(long productId, Product product);
}
