package com.pw.ecommerce.order.domain;

public interface OrderEventPublisher {

    void publish(OrderCreatedEvent event);
}
