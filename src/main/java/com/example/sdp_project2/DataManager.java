package com.example.sdp_project2;

import java.util.List;

public class DataManager {
    private static DataManager instance;
    private Product selectedProduct;
    private double totalPrice;
    private PaymentStrategy paymentStrategy;
    private String data;

    private DataManager() {

    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product product) {
        this.selectedProduct = product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}