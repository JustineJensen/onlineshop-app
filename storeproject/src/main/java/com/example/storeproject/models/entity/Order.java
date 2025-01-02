package com.example.storeproject.models.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.control.MappingControl;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    @Schema(description = "manager of the employee")
    private User user;

    @Column(name = "order_date",nullable = false)
    @Schema(description = "Order date",example = "2024-02-12")
    private LocalDateTime orderDate;

    @Schema(description = " Total price of the products" ,example = "100kr")
    @Column(name="total_price",nullable = false)
    private double totalPrice;

}
