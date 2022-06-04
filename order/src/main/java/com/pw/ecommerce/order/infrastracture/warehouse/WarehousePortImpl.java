package com.pw.ecommerce.order.infrastracture.warehouse;

import com.pw.ecommerce.order.domain.Product;
import com.pw.ecommerce.order.domain.warehouse.ProductsReservation;
import com.pw.ecommerce.order.domain.warehouse.WarehousePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class WarehousePortImpl implements WarehousePort {

    private final static String RESERVE_ID = "reserve_id";

    @Override
    public ProductsReservation reserve(List<Product> reserveProducts) {
        return new ProductsReservation(RESERVE_ID, false);
    }

    @Override
    public void confirmReservation(String reservationId) {
        //cos tam...
    }
}
