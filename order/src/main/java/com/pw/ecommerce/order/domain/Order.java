package com.pw.ecommerce.order.domain;

import com.pw.ecommerce.order.domain.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

import static com.pw.ecommerce.order.domain.Money.ZERO_PLN;
import static com.pw.ecommerce.order.domain.OrderStatus.CREATED;
import static com.pw.ecommerce.order.domain.OrderStatus.WAITING_FOR_PAYMENT;

@Aggregate

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Order {
    private String orderId;
    private Customer customer;
    private List<Product> products;
    private OrderStatus status;
    private Money cost;

    private DiscountPolicy discountPolicy;

    public void initializeForPayment() {
        if (!status.equals(CREATED)) {
            throw new RuntimeException("Illegal status!");
        }

        var costOfGoods = calculatePrizeOfGoods();

        var rabat = discountPolicy.calculate(this);

        this.cost = costOfGoods.subtract(rabat);

        status = WAITING_FOR_PAYMENT;
    }

    public Money calculatePrizeOfGoods() {
        return products.stream()
                .map(product ->
                        product.getPrize().multiple(BigDecimal.valueOf(product.getQuantity()))
                )
                .reduce(Money::add)
                .orElse(ZERO_PLN);
    }
}
