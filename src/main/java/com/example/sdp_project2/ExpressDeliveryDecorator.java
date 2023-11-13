package com.example.sdp_project2;

class ExpressDeliveryDecorator extends ProductDecorator {
    ExpressDeliveryDecorator(Product product) {
        super(product);
    }

    @Override
    double getPrice() {
        return product.price + 10; // Express delivery cost
    }
}
