package com.example.productservice.service;

import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
@Service("productServiceDB")
public class ProductServiceDBImpl implements ProductService{
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public void updateProduct(long productId, Product product) {
    }
}
