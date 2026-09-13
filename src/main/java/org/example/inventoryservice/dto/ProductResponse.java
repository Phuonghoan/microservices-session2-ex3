package org.example.inventoryservice.dto;

public record ProductResponse(

        Long id,

        String name,

        Integer quantity

) {
}
