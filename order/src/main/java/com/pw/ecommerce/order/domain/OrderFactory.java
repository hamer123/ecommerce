package com.pw.ecommerce.order.domain;

import com.pw.ecommerce.order.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderFactory {

    private final Map<CustomerLoyalty, DiscountPolicy> discountPolicyPerCustomerLoyalty;

    @Autowired
    public OrderFactory(List<DiscountPolicy> discountPolicies) {
        this.discountPolicyPerCustomerLoyalty = discountPolicies.stream().collect(Collectors.toMap(DiscountPolicy::forLoyalty, Function.identity()));
    }

    public Order create(Customer customer, List<Product> products) {
        return Order.builder()
                .orderId(UUID.randomUUID().toString())
                .products(products)
                .customer(customer)
                .status(OrderStatus.CREATED)
                .discountPolicy(discountPolicyPerCustomerLoyalty.get(customer.getLoyalty()))
                .build();
    }
}
