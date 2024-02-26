package com.example.webmarket.product.dto;

import jakarta.transaction.Transactional;
import lombok.Data;

@Data
@Transactional
public class ProductDto {
    private String name;
    private Integer amount;
    private Integer price;
    private String image;

}
