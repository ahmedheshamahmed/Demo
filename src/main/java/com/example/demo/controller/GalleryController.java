package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.CartItem;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("cart")
public class GalleryController {

    private final ProductService productService;

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart(); // Initialize the cart in the session
    }

    // Constructor injection
    public GalleryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/gallery")
    public String gallery(Model model) {
        List<Product> featuredProducts = productService.getFeaturedProducts();
        model.addAttribute("featuredProducts", featuredProducts);
        model.addAttribute("title", "Gallery - Loomi's Macrame Brand");
        return "gallery"; // This will map to gallery.html
    }

    @GetMapping("/product/{id}")
    public String viewProductDetails(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-details"; // This should match the name of your HTML template
    }

    @PostMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        Product product = productService.getProductById(id);
        CartItem item = new CartItem(product.getId(), product.getName(), product.getPrice(), 1);
        cart.addItem(item);
        return "cart";
    }


    @PostMapping("/remove-from-cart/{id}")
    public String removeFromCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        cart.removeItem(id);
        return "cart";
    }


}
