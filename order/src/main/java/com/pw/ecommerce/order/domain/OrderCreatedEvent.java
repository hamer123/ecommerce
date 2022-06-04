package com.pw.ecommerce.order.domain;

import org.springframework.context.ApplicationEvent;

public class OrderCreatedEvent extends ApplicationEvent {

    public OrderCreatedEvent(Object source) {
        super(source);
    }
}
