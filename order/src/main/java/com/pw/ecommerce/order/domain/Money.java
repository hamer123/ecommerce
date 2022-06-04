package com.pw.ecommerce.order.domain;

import java.math.BigDecimal;

public record Money(String currency, BigDecimal amount) {

    public static Money ZERO_PLN = new Money("PLN", BigDecimal.ZERO);

    public Money add(Money input) {
        if (!input.currency.equals(currency)) {
            throw new IllegalArgumentException("Not the same currency!");
        }

        return new Money(currency, amount.add(input.amount));
    }

    public Money subtract(Money input) {
        if (!input.currency.equals(currency)) {
            throw new IllegalArgumentException("Not the same currency!");
        }

        return new Money(currency, amount.subtract(input.amount));
    }


    public Money multiple(BigDecimal value) {
        return new Money(currency, amount.multiply(value));
    }
}
