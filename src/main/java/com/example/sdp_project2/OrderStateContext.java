package com.example.sdp_project2;

class OrderStateContext {
    private OrderStatusObserver orderStatusObserver;

    void setOrderStatusObserver(OrderStatusObserver observer) {
        orderStatusObserver = observer;
    }

    String updateOrderStatus(String status) {
        return orderStatusObserver.update(status);
    }
}
