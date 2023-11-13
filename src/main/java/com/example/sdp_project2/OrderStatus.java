package com.example.sdp_project2;

class OrderStatus implements OrderStatusObserver {
    private String status;
    public OrderStatus(){this.status = status;}

    @Override
    public String update(String status) {

        return "Order Status: " + status;
    }
}
