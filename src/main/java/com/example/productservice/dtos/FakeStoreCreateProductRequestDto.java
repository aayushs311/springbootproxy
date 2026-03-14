package com.example.productservice.dtos;

import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductRequestDto {
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public static FakeStoreCreateProductRequestDto fromProduct(Product product){
        FakeStoreCreateProductRequestDto fakeStoreCreateProductRequestDto = new FakeStoreCreateProductRequestDto();

        fakeStoreCreateProductRequestDto.setTitle(product.getTitle());
        fakeStoreCreateProductRequestDto.setImage(product.getImageUrl());
        fakeStoreCreateProductRequestDto.setPrice(product.getPrice());
        fakeStoreCreateProductRequestDto.setDescription(product.getDescription());
        fakeStoreCreateProductRequestDto.setCategory(product.getCategory());

        return fakeStoreCreateProductRequestDto;
    }

}
