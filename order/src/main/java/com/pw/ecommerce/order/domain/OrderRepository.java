package com.pw.ecommerce.order.domain;

public interface OrderRepository {

    Order getById(String orderId);

    Order save(Order order);
}
