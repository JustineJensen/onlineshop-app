package com.example.storeproject.services.product;

import com.example.storeproject.models.entity.Product;
import com.example.storeproject.services.CrudService;

import java.util.Optional;

public interface ProductService extends CrudService<Product,Long> {
    Optional<Product>findByCategory(String category);
}
