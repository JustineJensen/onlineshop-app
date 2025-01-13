package com.example.storeproject.controller;

import com.example.storeproject.mappers.ProductMapper;
import com.example.storeproject.models.dtos.products.ProductDTO;
import com.example.storeproject.models.dtos.products.ProductPostDTO;
import com.example.storeproject.models.dtos.products.ProductUpdateDTO;
import com.example.storeproject.models.dtos.user.UserDTO;
import com.example.storeproject.models.dtos.user.UserPostDTO;
import com.example.storeproject.models.dtos.user.UserUpdateDTO;
import com.example.storeproject.models.entity.Product;
import com.example.storeproject.models.entity.User;
import com.example.storeproject.services.product.ProductService;
import com.example.storeproject.utils.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name ="Product",description = "Endpoints to interact with Products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    //Get list of products
    @Operation(summary = "Get a list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Malformed request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
    })
    @GetMapping
    @CrossOrigin
    public ResponseEntity<Collection<ProductDTO>> getAllProducts() {
        Collection<Product> products = productService.findAll();
        Collection<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            productDTOS.add(productMapper.productToProductDTO(product));
        }
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }


    @Operation(summary = "Get a Product by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Malformed request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
    })
    @CrossOrigin
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable long productId) {
        Product product = productService.findById(productId);
        ProductDTO dto = productMapper.productToProductDTO(product);
        if (product != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @Operation(summary = "Create a new Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserPostDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Malformed request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)))
    })
    @PostMapping
    @CrossOrigin
    public ResponseEntity<Void> createNewProduct(@RequestBody ProductPostDTO productPostDTO) {
        try {
            Product product = new Product();
            product.setProductName(productPostDTO.getProductName());
            product.setDescription(productPostDTO.getDescription());
            product.setPrice(productPostDTO.getPrice());
            product.setCategory(productPostDTO.getCategory());
            product.setImageUrl(productPostDTO.getImageUrl());
            productService.add(product);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            System.err.println("Error creating product:" + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Update an existing product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Malformed request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
    })
    @CrossOrigin
    @PutMapping("/{userId}")
    public ResponseEntity<Void>updateProduct(@PathVariable Long productId, @RequestBody ProductUpdateDTO productUpdateDTO){
        Product existingProduct = productService.findById(productId);
        if(existingProduct == null){
            return ResponseEntity.notFound().build();
        }
        existingProduct.setProductName(productUpdateDTO.getProductName());
        existingProduct.setDescription(productUpdateDTO.getDescription());
        existingProduct.setCategory(productUpdateDTO.getCategory());
        existingProduct.setImageUrl(productUpdateDTO.getImageUrl());
        productService.update(existingProduct);
        return  ResponseEntity.noContent().build();
    }
    @Operation(summary = "Delete a Product by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Malformed request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))),
    })
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void>deleteProduct(@PathVariable Long productId){
        Product product= productService.findById(productId);
        productService.deleteById(productId);
        return  ResponseEntity.noContent().build();
    }
}

