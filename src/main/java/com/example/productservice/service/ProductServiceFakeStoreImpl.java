package com.example.productservice.service;

import com.example.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.example.productservice.dtos.FakeStoreResponseDto;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Service
//@Primary // In case of conflict this class's object will be used
@Service("productServiceFakeStore")
public class ProductServiceFakeStoreImpl implements ProductService{

    private final RestTemplate restTemplate;

    public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto requestBody = new FakeStoreCreateProductRequestDto();
        requestBody.setTitle(product.getTitle());
        requestBody.setPrice(product.getPrice());
        requestBody.setImage(product.getImageUrl());
        requestBody.setDescription(product.getDescription());
        requestBody.setCategory(product.getCategory());
        FakeStoreResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                requestBody,
                FakeStoreResponseDto.class
        );
        Product product1 = new Product();
        product1.setId(response.getId());
        product1.setPrice(response.getPrice());
        product1.setImageUrl(response.getImage());
        product1.setTitle(response.getTitle());
        product1.setDescription(response.getDescription());
        return product;
    }
}
