package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {


    private final List<Product> products = Arrays.asList(
            new Product(1L, "Wall Hanging", "Handcrafted wall decor", "250.00 EGP", "/images/homepage-img.jpg"),
            new Product(2L, "Plant Hanger", "Beautiful macrame plant hanger", "300.00 EGP", "/images/homepage-img.jpg"),
            new Product(3L, "Boho Tapestry", "Stylish boho tapestry", "620.00 EGP", "/images/homepage-img.jpg")
    );

    public List<Product> getFeaturedProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
