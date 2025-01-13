package com.example.storeproject.models.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Schema(description ="Represents a product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Schema(description = "ID of the product,example 1234")
    @Column (name = "product_id",nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    @Schema(description = "Name of the product")
    private String productName;

    @Column(name = "product_description", nullable = false)
    @Schema(description = "information about the product")
    private String description;

    @Column(name = "product_price", nullable = false)
    @Schema(description = "Price of the product")
    private double price;

    @Column(name = "product_category", nullable = false)
    @Schema(description = "Distinguish between honey and dates", example = "honey or dates")
    private String category;

    @Column(name = "product_image", nullable = false)
    @Schema(description = "product image")
    private String imageUrl;


}
