package com.example.storeproject.models.dtos.cart;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CartDto {

    private long userId;
    private long cartId;
    private double totalPrice;
    private boolean checkedOut;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
