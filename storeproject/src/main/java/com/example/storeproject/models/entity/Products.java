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
public class Products {
    @Id
    @GeneratedValue
    @Schema(description = "ID of the product,example 1234")
    @Column (name = "product_id",nullable = false)
    private long productId;

    @Column(name = "product_name", nullable = false)
    @Schema(description = "Name of the product")
    private String productName;

    @Column(name = "product description", nullable = false)
    @Schema(description = "information about the product")
    private String description;

    @Column(name = "product price", nullable = false)
    @Schema(description = "Price of the product")
    private double price;

    @Column(name = "product category", nullable = false)
    @Schema(description = "product category", example = "honey or dates")
    private String category;

    @Column(name = "product image", nullable = false)
    @Schema(description = "product image")
    private String imageUrl;


}
