package com.pw.ecommerce.order.domain;

import java.util.List;

public interface OrderService {
    Order create(String customerId, List<Product> products);

    void initializeForPayment(String orderId);

    void collectGoods(String orderId);
}
