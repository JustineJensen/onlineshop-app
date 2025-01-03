package com.example.storeproject.models.dtos.order;

import com.example.storeproject.models.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class OrderUpdateDto {
    private long id;
    private User user;
    private LocalDateTime orderDate;
    private double totalPrice;

}
