package com.example.sdp_project2;

abstract class ProductDecorator extends Product {
    Product product;

    ProductDecorator(Product product) {
        super(product.name, product.price);
        this.product = product;
    }

    abstract double getPrice();
}