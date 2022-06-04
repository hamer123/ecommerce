package com.pw.ecommerce.order.domain;

public interface EventPublisher {
    void publish(Object event);
}
