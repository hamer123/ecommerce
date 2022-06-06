package com.pw.ecommerce.order.domain;

import com.pw.ecommerce.order.domain.customer.Customer;
import com.pw.ecommerce.order.domain.customer.CustomerPort;
import com.pw.ecommerce.order.domain.pricing.PricingPort;
import com.pw.ecommerce.order.domain.warehouse.WarehousePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final WarehousePort warehousePort;

    private final PricingPort pricingPort;

    private final OrderFactory orderFactory;

    private final EventPublisher eventPublisher;

    private final CustomerPort customerPort;

    private final OrderRepository orderRepository;

    @Override
    public Order create(String customerId, List<Product> products) {
        var productsReservation = warehousePort.reserve(products);
        var productsWithPrice = pricingPort.getPricing(toProductIds(products));
        var customer = customerPort.getById(customerId);

        var order = orderFactory.create(customer, productsWithPrice);

        warehousePort.confirmReservation(productsReservation.reserveId());

        eventPublisher.publish(new OrderCreatedEvent(order));

        return order;
    }

    private static List<String> toProductIds(List<Product> products) {
        return products.stream().map(Product::getProductId).collect(Collectors.toList());
    }

    @Override
    public void initializeForPayment(String orderId) {
        var order = orderRepository.getById(orderId);
        order.initializeForPayment();

        //event do uslugi platnosci? czy tez rest?
        orderRepository.save(order);
    }

    @Override
    public void collectGoods(String orderId) {
        var order = orderRepository.getById(orderId);
        order.collectGoods();
        orderRepository.save(order);
    }
}
