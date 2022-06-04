package com.pw.ecommerce.order.domain.customer;

import com.pw.ecommerce.order.domain.CustomerLoyalty;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Value
public class Customer {
    @NotBlank
    String customerId;
    @NotNull
    CustomerLoyalty loyalty;
}
