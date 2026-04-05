package com.example.productservice.dtos.db;

import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDto {
    private long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;

    public static CreateProductResponseDto fromProduct(Product product) {
        CreateProductResponseDto createProductResponseDto = new CreateProductResponseDto();

        createProductResponseDto.setId(product.getId());
        createProductResponseDto.setTitle(product.getTitle());
        createProductResponseDto.setDescription(product.getDescription());
        createProductResponseDto.setPrice(product.getPrice());
        createProductResponseDto.setImageUrl(product.getImageUrl());
        createProductResponseDto.setCategory(product.getCategory().getName());

        return createProductResponseDto;
    }
}
