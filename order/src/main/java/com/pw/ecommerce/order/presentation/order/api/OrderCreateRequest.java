package com.pw.ecommerce.order.presentation.order.api;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
class OrderCreateRequest {

    private String customerId;
    private List<RequestedProduct> products;
    private OrderDelivery orderDelivery;

    @Data
    @Builder
    static class RequestedProduct {
        private String productId;
        private int quantity;
    }

    @Data
    @Builder
    static class OrderDelivery {
        private DeliveryType type;
        private Address address;

        enum DeliveryType {
            COURIER, PARCEL_LOCKER;
        }
    }

    @Data
    @Builder
    static class Address {
        private String country;
        private String city;
        private String street;
        private String zipCode;
    }
}
