package com.example.sdp_project2;

class PayPalPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Paid $" + amount + " using PayPal.";
    }
}
