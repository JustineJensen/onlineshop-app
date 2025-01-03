package com.example.storeproject.models.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Setter
@Getter
public class Cart{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = " cart id ", example = "1234")
    private long cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(name= "total_price",nullable = false)
    @Schema(description = "total price of allt he items in the cart ", example = "19000kr")
    private double totalPrice;

    @Column(name = "checked_out",nullable = false)
    @Schema(description = "shows if the user has checked out")
    private boolean checkedOut;

    @Column(name = "created_at",nullable = false)
    @Schema(description = "The date when the item was added in the cart")
    private LocalDateTime createdAt;

    @Column(name ="updated_at",nullable = false)
    @Schema(description = "The date when the item was updated in the cart")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<CartItem> items = new ArrayList<>();


}
