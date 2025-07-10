package com.sun.apps.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Product Management", description = "Operations related to products")

public class ProductController {

    @Operation(summary = "Get product details", description = "Fetch details of a product by its ID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Product found",
                    content = @Content(
                            schema = @Schema(implementation = Product.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Product not found"
            )
    })
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return new Product(id, "Sample Product", 100.0);
    }
}

class Product {
    private Long id;
    private String name;
    private Double price;

    // Constructor, getters, and setters omitted for brevity.

    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}