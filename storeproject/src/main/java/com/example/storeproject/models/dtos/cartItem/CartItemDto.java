package com.example.storeproject.models.dtos.cartItem;

import com.example.storeproject.models.entity.Cart;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class CartItemDto {
    private long id;
    private Cart cart;
    private int quantity;
    private double price;
}
