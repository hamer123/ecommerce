package com.pw.ecommerce.order.domain.warehouse;

import lombok.Builder;

@Builder
public record ProductsReservation(String reserveId, boolean isConfirmed) {
}
