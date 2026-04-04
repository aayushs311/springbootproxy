package com.example.productservice.controller;

import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.dtos.CreateProductResponseDto;
import com.example.productservice.dtos.GetProductResponseDto;
import com.example.productservice.dtos.UpdateProductResponseDto;
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

    public ProductController(@Qualifier("productServiceDB") ProductService productService) {
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
            getProductResponseDtos.add(GetProductResponseDto.fromProduct(product));
        }
        return getProductResponseDtos;
    }

//    @PatchMapping("/{id}")
//    public UpdateProductResponseDto updateProduct(@PathVariable("id") long productId, @RequestBody CreateProductRequestDto createProductRequestDto) {
//        Product product = productService.updateProduct(productId, createProductRequestDto.toProduct());
//        UpdateProductResponseDto updateProductResponseDto = new UpdateProductResponseDto();
//        updateProductResponseDto.setProduct(CreateProductResponseDto.fromProduct(product));
//        return updateProductResponseDto;
//    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") long productId, @RequestBody CreateProductRequestDto createProductRequestDto) {
        productService.updateProduct(productId, createProductRequestDto.toProduct());
        return "Product with ID: " + productId + " has been updated";
    }

    /**
     * Below is the way how we handle exception.
     * The only disadvantage of handling exception this way is that it will only work at this particular
       controller only.
     * To handle exception at the top(global) level. We need to use Controller Advices
     */
//    @ExceptionHandler(Exception.class)
//    public String handleException() {
//        return "Exception has been handled";
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public String handleRuntimeException() {
//        return "RuntimeException has been handled";
//    }
}
