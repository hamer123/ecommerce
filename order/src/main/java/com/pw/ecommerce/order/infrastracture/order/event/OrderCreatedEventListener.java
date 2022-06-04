package com.pw.ecommerce.order.infrastracture.order.event;

import com.pw.ecommerce.order.domain.OrderCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
class OrderCreatedEventListener implements ApplicationListener<OrderCreatedEvent> {

    @Override
    public void onApplicationEvent(OrderCreatedEvent event) {

    }
}
