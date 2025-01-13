package com.example.storeproject.models.dtos.products;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductDTO {
    @Schema(description = "ID of the product")
    private long productId;

    @Schema(description = "Name of the product")
    private String productName;

    @Schema(description = "Description of the product")
    private String description;

    @Schema(description = "Price of the product")
    private double price;

    @Schema(description = "Category of the product")
    private String category;

    @Schema(description = "URL of the product image")
    private String imageUrl;

}
