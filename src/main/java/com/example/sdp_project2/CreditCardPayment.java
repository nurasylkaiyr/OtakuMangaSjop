package com.example.sdp_project2;

class CreditCardPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Paid $" + amount + " using Credit Card.";
    }
}
