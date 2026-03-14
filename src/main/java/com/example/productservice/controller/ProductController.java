package com.example.productservice.controller;

import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.dtos.CreateProductResponseDto;
import com.example.productservice.dtos.GetProductResponseDto;
import com.example.productservice.models.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("productServiceFakeStore") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
        Product product = productService.createProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping
    public List<GetProductResponseDto> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<GetProductResponseDto> getProductResponseDtos = new ArrayList<>();
        for(Product product: products) {
            getProductResponseDtos.add(GetProductResponseDto.from(product));
        }
        return getProductResponseDtos;
    }

    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable("id") long id) {

    }
}
