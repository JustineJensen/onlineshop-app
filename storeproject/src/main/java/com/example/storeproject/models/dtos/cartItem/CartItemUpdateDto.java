package com.example.storeproject.models.dtos.cartItem;

import com.example.storeproject.models.entity.Cart;
import lombok.Data;

@Data
public class CartItemUpdateDto {
    private long id;
    private Cart cart;
    private int quantity;
    private double price;
}
