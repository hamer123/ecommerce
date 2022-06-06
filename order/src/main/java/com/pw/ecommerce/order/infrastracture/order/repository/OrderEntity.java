package com.pw.ecommerce.order.infrastracture.order.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class OrderEntity {

    @Id
    private String id;

    private String customerId;

    @Enumerated(EnumType.STRING)
    private CustomerLoyaltyEntity customerLoyalty;

    @Enumerated(EnumType.STRING)
    private OrderStatusEntity status;

    @OneToMany //(cascade = CascadeType.ALL)
    private List<ProductEntity> products;
}
