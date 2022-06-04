package com.pw.ecommerce.order.domain.warehouse;

import com.pw.ecommerce.order.domain.Product;

import java.util.List;

public interface WarehousePort {

    ProductsReservation reserve(List<Product> reserveProducts);

    void confirmReservation(String reservationId);
}
