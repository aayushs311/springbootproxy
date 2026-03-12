package com.example.productservice.service;

import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

//@Service
@Service("productServiceDB")
public class ProductServiceDBImpl implements ProductService{
    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
