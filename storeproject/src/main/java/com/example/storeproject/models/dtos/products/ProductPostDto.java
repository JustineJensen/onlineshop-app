package com.example.storeproject.models.dtos.products;

import lombok.Data;

@Data
public class ProductPostDto {
    private String productName;
    private String description;
    private double price;
    private String category;
    private String imageUrl;
}
