package com.example.sdp_project2;

class PackagingDecorator extends ProductDecorator {
    PackagingDecorator(Product product) {
        super(product);
    }

    @Override
    double getPrice() {
        return product.price + 5; // Packaging cost
    }
}