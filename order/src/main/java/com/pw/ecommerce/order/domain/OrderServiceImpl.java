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

    @Override
    public Order create(String customerId, List<Product> products) {
        //reserve goods
        var productsReservation = warehousePort.reserve(products);

        //get goods prizes
        var productsWithPrice = pricingPort.getPricing(toProductIds(products));

        //get customer
        var customer = customerPort.getById(customerId);

        //create order with status created
        var order = orderFactory.create(customer, productsWithPrice);

        warehousePort.confirmReservation(productsReservation.reserveId());

        //emmit event order created
        eventPublisher.publish(new OrderCreatedEvent(order));
        //todo emmit

        return order;
    }

    private static List<String> toProductIds(List<Product> products) {
        return products.stream().map(Product::getProductId).collect(Collectors.toList());
    }

    @Override
    public void payment(String orderId) {
        //zaplacono xd
    }
}
