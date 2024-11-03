package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        // If the item is already in the cart, update the quantity
        for (CartItem cartItem : items) {
            if (cartItem.getProductId().equals(item.getProductId())) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(Long productId) {
        items.removeIf(item -> item.getProductId().equals(productId));
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(item -> Double.parseDouble(item.getPrice().split("\\.")[0]) * item.getQuantity()).sum();
    }
}
