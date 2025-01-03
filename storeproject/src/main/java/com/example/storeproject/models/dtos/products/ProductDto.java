package com.example.storeproject.models.dtos.products;

import lombok.Data;

@Data
public class ProductDto {
    private long productId;
    private String productName;
    private String description;
    private double price;
    private String category;
    private String imageUrl;

}
