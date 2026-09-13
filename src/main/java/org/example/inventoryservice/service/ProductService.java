package org.example.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import org.example.inventoryservice.dto.ProductResponse;
import org.example.inventoryservice.entity.Product;
import org.example.inventoryservice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository
            productRepository;

    public List<ProductResponse> getProducts() {

        return productRepository
                .findAll()
                .stream()
                .map(product ->
                        new ProductResponse(
                                product.getId(),
                                product.getName(),
                                product.getQuantity()
                        )
                )
                .toList();
    }

    public ProductResponse createProduct(
            Product product
    ) {

        Product saved =
                productRepository.save(
                        product
                );

        return new ProductResponse(

                saved.getId(),

                saved.getName(),

                saved.getQuantity()
        );
    }
}
