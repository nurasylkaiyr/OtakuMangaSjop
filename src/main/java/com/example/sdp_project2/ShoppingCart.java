package com.example.sdp_project2;

import java.util.ArrayList;
import java.util.List;
// Singleton pattern for shopping cart
class ShoppingCart {
    private static ShoppingCart instance;
    private List<Product> products;

    private ShoppingCart() {
        products = new ArrayList<>();
    }

    static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    List<Product> getProducts() {
        return products;
    }
}
