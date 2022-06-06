package com.pw.ecommerce.order.domain.customer;

public interface CustomerPort {
    Customer getById(String customerId);
}
