package com.example.demo.service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public List<Product> getFeaturedProducts() {
        return productDao.findAll();
    }

    public Product getProductById(Long id) {
        return productDao.findAll().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
