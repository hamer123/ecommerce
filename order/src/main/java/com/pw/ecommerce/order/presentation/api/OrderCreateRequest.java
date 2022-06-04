package com.pw.ecommerce.order.presentation.api;

import lombok.Builder;

import java.util.List;

@Builder
record OrderCreateRequest(String customerId, List<RequestedProduct> products) {

    @Builder
    record RequestedProduct(String productId, int quantity) {
    }
}
