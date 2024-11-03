package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.CartItem;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;


    // Constructor injection
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Product> featuredProducts = productService.getFeaturedProducts();
        model.addAttribute("featuredProducts", featuredProducts);
        model.addAttribute("title", "Welcome to Loomi's Macrame Brand");
        return "home"; // This will map to home.html
    }

    @GetMapping("/home/product/{id}")
    public String viewProductDetails(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-details"; // This should match the name of your HTML template
    }

    @PostMapping("/home/add-to-cart/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        Product product = productService.getProductById(id);
        CartItem item = new CartItem(product.getId(), product.getName(), product.getPrice(), 1);
        cart.addItem(item);
        return "cart";
    }

}
