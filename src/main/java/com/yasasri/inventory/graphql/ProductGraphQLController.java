package com.yasasri.inventory.graphql;

import com.yasasri.inventory.model.Product;
import com.yasasri.inventory.repository.ProductRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductGraphQLController {

    private final ProductRepository productRepository;

    public ProductGraphQLController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryMapping
    public List<Product> products(@Argument String category) {
        if (category != null) {
            return productRepository.findByCategoryName(category);
        }
        return productRepository.findAll();
    }

    @QueryMapping
    public Product productById(@Argument Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Product> lowStockProducts() {
        return productRepository.findLowStockProducts();
    }
}
