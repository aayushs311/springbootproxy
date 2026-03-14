package com.example.productservice.service;

import com.example.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.example.productservice.dtos.FakeStoreCreateProductResponseDto;
import com.example.productservice.dtos.FakeStoreGetProductResponseDto;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
        FakeStoreCreateProductResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                requestBody,
                FakeStoreCreateProductResponseDto.class
        );
        Product product1 = new Product();
        product1.setId(response.getId());
        product1.setPrice(response.getPrice());
        product1.setImageUrl(response.getImage());
        product1.setTitle(response.getTitle());
        product1.setDescription(response.getDescription());
        return product;
    }

    /*
        List<FakeStoreGetProductResponseDto>.class does not work here because Java removes type during the
        runtime for backward compatibility. Thus, Type will be removed during the runtime(Type erasure) & that
        time Java does not know about the response type. It only knows that it is a List, Array, etc...
     */
    @Override
    public List<Product> getAllProducts() {
        FakeStoreGetProductResponseDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreGetProductResponseDto[].class
        );
        List<FakeStoreGetProductResponseDto> responseDtoList = Stream.of(response).toList();

        List<Product> products = new ArrayList<>();
        for (FakeStoreGetProductResponseDto fakeStoreGetProductResponseDto: responseDtoList) {
            products.add(fakeStoreGetProductResponseDto.toProduct());
        }
       return products;
    }
}
