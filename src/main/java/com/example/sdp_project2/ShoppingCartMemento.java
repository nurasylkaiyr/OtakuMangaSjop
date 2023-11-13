package com.example.sdp_project2;

import java.util.ArrayList;
import java.util.List;

class ShoppingCartMemento {
    private List<Product> products;

    ShoppingCartMemento(List<Product> products) {
        this.products = new ArrayList<>(products); // Create a copy of the product list
    }

    List<Product> getProducts() {
        return new ArrayList<>(products); // Return a copy of the product list
    }
}
