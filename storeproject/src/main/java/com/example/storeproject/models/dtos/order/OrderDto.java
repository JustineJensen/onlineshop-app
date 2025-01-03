package com.example.storeproject.models.dtos.order;

import com.example.storeproject.models.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class OrderDto {

    private long id;
    private User user;
    private LocalDateTime orderDate;
    private double totalPrice;

}
