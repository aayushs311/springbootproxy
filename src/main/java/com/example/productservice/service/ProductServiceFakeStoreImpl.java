package com.example.productservice.service;

import com.example.productservice.dtos.CreateProductRequestDto;
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
        FakeStoreCreateProductResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                FakeStoreCreateProductRequestDto.fromProduct(product),
                FakeStoreCreateProductResponseDto.class
        );
        return response.toProduct();
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

//    @Override
//    public Product updateProduct(long productId, Product product) {
//        FakeStoreCreateProductResponseDto response = restTemplate.patchForObject(
//                "https://fakestoreapi.com/products" + productId,
//                FakeStoreCreateProductRequestDto.fromProduct(product),
//                FakeStoreCreateProductResponseDto.class
//        );
//        return response.toProduct();
//    }

    public void updateProduct(long productId, Product product) {
        restTemplate.put(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreCreateProductRequestDto.fromProduct(product)
        );
    }
}
