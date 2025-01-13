package com.example.storeproject.mappers;

import com.example.storeproject.models.dtos.products.ProductDTO;
import com.example.storeproject.models.dtos.products.ProductPostDTO;
import com.example.storeproject.models.dtos.products.ProductUpdateDTO;
import com.example.storeproject.models.entity.Product;
import com.example.storeproject.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper (componentModel = "spring")
public abstract class ProductMapper {

    @Mapping(target = "productId", source ="product.productId")
    public abstract ProductDTO productToProductDTO(Product product);

    // Mapping from ProductPostDTO to Product (for creating or updating products)
    @Mapping(target = "productName", source = "productName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "imageUrl", source = "imageUrl")

    public abstract Product productPostDTOToProduct(ProductPostDTO productPostDTO);
    // Mapping from Product entity to ProductPostDTO
    @Mapping(target = "productName", source = "productName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "imageUrl", source = "imageUrl")
    public abstract ProductPostDTO productToProductPostDTO(Product product);


    @Mapping(target = "productId", source = "productDTO.productId")
    public abstract Product productDTOProduct(ProductDTO productDTO);

    @Named("mapSubordinatesToIds")
    public Set<Long> mapSubordinatesToIds(Set<User> source) {
        if (source == null) return null;
        return source.stream()
                .map(User::getUserId)
                .collect(Collectors.toSet());
    }

    // Create Products with Ids only
    @Named("mapSubordinatesToUser")
    public Set<User> mapSubordinatesToUsers(Set<Long> source) {
        if (source == null) return null;
        return source.stream().map(userId -> {
            User user = new User();
            user.setUserId(userId);
            return user;
        }).collect(Collectors.toSet());
    }

    @Mapping(target = "productName", source = "productName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "imageUrl", source = "imageUrl")
    public abstract Product productUpdateDtoToProduct(ProductUpdateDTO productUpdateDTO);



}
