package com.example.productservice.dtos;

import com.example.productservice.dtos.db.CreateProductResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductResponseDto {
    private CreateProductResponseDto product;
}
