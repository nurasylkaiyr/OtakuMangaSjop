package com.example.sdp_project2;

class DiscountDecorator extends ProductDecorator {
    DiscountDecorator(Product product) {
        super(product);
    }

    @Override
    double getPrice() {
        return product.price * 0.9; // 10% discount
    }
}
