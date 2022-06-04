package com.pw.ecommerce.order.domain;

public interface DiscountPolicy {

    Money calculate(Order order);

    CustomerLoyalty forLoyalty();
}
