package com.pw.ecommerce.order.domain;

public enum OrderStatus {
    CREATED, WAITING_FOR_PAYMENT, COLLECTING_GOODS, READY_TO_SEND, SENT,
    PAYMENT_FAILED;
}
