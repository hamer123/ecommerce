package com.pw.ecommerce.order.infrastracture.order.repository;

import com.pw.ecommerce.order.domain.Order;
import com.pw.ecommerce.order.domain.OrderFactory;
import com.pw.ecommerce.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class JpaOrderRepository implements OrderRepository {

    private final OrderFactory orderFactory;

    private final OrderEntityRepository orderEntityRepository;

    @Override
    public Order getById(String orderId) {
        return null;
    }

    @Override
    public Order save(Order order) {
        return null;
    }
}
