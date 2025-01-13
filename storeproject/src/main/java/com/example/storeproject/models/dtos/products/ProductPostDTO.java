package com.example.storeproject.models.dtos.products;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductPostDTO {
    @Schema(description = "Product name  ",example = "Raw honey")
    private String productName;
    @Schema(description = "Detailed information about a product")
    private String description;
    @Schema(description = "Price of the product ",example = "250SEK")
    private double price;
    @Schema(description = "Classification under which the product is categorized ",example = "Honey or Dates")
    private String category;
    @Schema(description = "Image of the product ")
    private String imageUrl;
}
