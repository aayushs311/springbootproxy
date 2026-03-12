package com.example.productservice.controller;

import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.dtos.CreateProductResponseDto;
import com.example.productservice.models.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("productServiceFakeStore") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable("id") long id) { // OR: @PathVariable long id
        return "Here is your product: " + id;
    }

    @PostMapping
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
        Product product = productService.createProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }
}
