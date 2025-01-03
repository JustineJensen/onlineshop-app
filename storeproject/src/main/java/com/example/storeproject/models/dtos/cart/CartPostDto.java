package com.example.storeproject.models.dtos.cart;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CartPostDto {
    private long userId;
    private double totalPrice;
    private boolean checkedOut;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
