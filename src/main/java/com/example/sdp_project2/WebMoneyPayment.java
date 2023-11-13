package com.example.sdp_project2;

class WebMoneyPayment implements PaymentStrategy {
    @Override
    public String pay(double amount) {
        return "Paid $" + amount + " using WebMoney.";
    }
}
