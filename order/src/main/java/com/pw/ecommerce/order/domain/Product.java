package com.pw.ecommerce.order.domain;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Value
@Builder
public class Product {
    @NotNull
    String productId;
    @NotNull
    Money prize;
    @Min(1)
    int quantity;
}
