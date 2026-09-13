package org.example.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.inventoryservice.dto.ProductResponse;
import org.example.inventoryservice.entity.Product;
import org.example.inventoryservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService
            productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>>
    getProducts() {

        return ResponseEntity.ok(
                productService.getProducts()
        );
    }

    @PostMapping
    public ResponseEntity<ProductResponse>
    createProduct(
            @RequestBody Product product
    ) {
        return ResponseEntity
                .status(201)
                .body(
                        productService
                                .createProduct(product)
                );
    }
}
