package com.example.productservice.dtos;

import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductResponseDto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;

    public static GetProductResponseDto fromProduct(Product product) {
        GetProductResponseDto getProductResponseDto = new GetProductResponseDto();

        getProductResponseDto.setId(product.getId());
        getProductResponseDto.setTitle(product.getTitle());
        getProductResponseDto.setCategory(product.getCategory());
        getProductResponseDto.setPrice(product.getPrice());
        getProductResponseDto.setImageUrl(product.getImageUrl());
        getProductResponseDto.setDescription(product.getDescription());

        return getProductResponseDto;
    }
}
